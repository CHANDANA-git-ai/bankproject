package bank;

import java.sql.*;

/*
 * DAO Implementation class
 * Contains actual JDBC code
 */
public class CustomerDAOImpl implements CustomerDAO {

    // Add new customer
    @Override
    public void addCustomer(CustomerDTO c) throws Exception {

        String sql = "INSERT INTO customers(name,email,mobile,city,balance,status) VALUES (?,?,?,?,?,?)";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, c.getName());
        ps.setString(2, c.getEmail());
        ps.setString(3, c.getMobile());
        ps.setString(4, c.getCity());
        ps.setDouble(5, c.getBalance());
        ps.setString(6, "ACTIVE");

        ps.executeUpdate();
        con.close();
    }

    // Display all customers
    @Override
    public void viewCustomers() throws Exception {

        String sql = "SELECT * FROM customers";
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        System.out.println("\nID | Name | Email | Balance | Status");
        while (rs.next()) {
            System.out.println(
                rs.getInt("id") + " | " +
                rs.getString("name") + " | " +
                rs.getString("email") + " | " +
                rs.getDouble("balance") + " | " +
                rs.getString("status")
            );
        }
        con.close();
    }

    // Update customer details
    @Override
    public boolean updateCustomer(CustomerDTO c) throws Exception {

        String sql = "UPDATE customers SET name=?, email=?, mobile=?, city=? WHERE id=?";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, c.getName());
        ps.setString(2, c.getEmail());
        ps.setString(3, c.getMobile());
        ps.setString(4, c.getCity());
        ps.setInt(5, c.getId());

        boolean updated = ps.executeUpdate() > 0;
        con.close();
        return updated;
    }

    // Delete customer
    @Override
    public boolean deleteCustomer(int id) throws Exception {

        String sql = "DELETE FROM customers WHERE id=?";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);
        boolean deleted = ps.executeUpdate() > 0;
        con.close();
        return deleted;
    }

    // Deposit money
    @Override
    public boolean deposit(int id, double amount) throws Exception {

        String sql = "UPDATE customers SET balance = balance + ? WHERE id=?";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setDouble(1, amount);
        ps.setInt(2, id);

        boolean success = ps.executeUpdate() > 0;
        con.close();
        return success;
    }

    // Withdraw money with balance check
    @Override
    public boolean withdraw(int id, double amount) throws Exception {

        Connection con = DBConnection.getConnection();

        String check = "SELECT balance FROM customers WHERE id=?";
        PreparedStatement ps1 = con.prepareStatement(check);
        ps1.setInt(1, id);
        ResultSet rs = ps1.executeQuery();

        if (rs.next() && rs.getDouble("balance") >= amount) {
            String sql = "UPDATE customers SET balance = balance - ? WHERE id=?";
            PreparedStatement ps2 = con.prepareStatement(sql);
            ps2.setDouble(1, amount);
            ps2.setInt(2, id);
            ps2.executeUpdate();
            con.close();
            return true;
        }

        con.close();
        return false;
    }
}
