package bank;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
 * DAO class
 * Contains all database related operations
 * No user input or printing logic here
 */
public class CustomerDAO {

    // Insert customer into database
    public void addCustomer(Customer c) {
        String sql = "INSERT INTO customers(name,email,mobile,city) VALUES (?,?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getName());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getMobile());
            ps.setString(4, c.getCity());

            ps.executeUpdate();
            System.out.println("Customer added successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Fetch all customers
    public List<Customer> viewCustomers() {
        List<Customer> list = new ArrayList<>();
        String sql = "SELECT * FROM customers";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                // Create Customer object from ResultSet
                list.add(new Customer(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("mobile"),
                        rs.getString("city")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Fetch customer by ID
    public Customer getCustomerById(int id) {
        String sql = "SELECT * FROM customers WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Customer(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("mobile"),
                        rs.getString("city")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update mobile number of customer
    public boolean updateCustomerMobile(int id, String mobile) {
        String sql = "UPDATE customers SET mobile=? WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, mobile);
            ps.setInt(2, id);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete customer by ID
    public boolean deleteCustomer(int id) {
        String sql = "DELETE FROM customers WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Count total customers
    public int getCustomerCount() {
        String sql = "SELECT COUNT(*) FROM customers";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            if (rs.next())
                return rs.getInt(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Fetch customers based on city
    public List<Customer> getCustomersByCity(String city) {
        List<Customer> list = new ArrayList<>();
        String sql = "SELECT * FROM customers WHERE city=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, city);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Customer(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("mobile"),
                        rs.getString("city")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
