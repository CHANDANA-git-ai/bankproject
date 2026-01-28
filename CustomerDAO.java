package bank;

/*
 * DAO Interface
 * Declares all database operations
 */
public interface CustomerDAO {

    void addCustomer(CustomerDTO c) throws Exception;

    void viewCustomers() throws Exception;

    boolean updateCustomer(CustomerDTO c) throws Exception;

    boolean deleteCustomer(int id) throws Exception;

    boolean deposit(int id, double amount) throws Exception;

    boolean withdraw(int id, double amount) throws Exception;
}
