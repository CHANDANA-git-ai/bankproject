package bank;

import java.util.List;
import java.util.Scanner;

/*
 * Service layer
 * Handles user input and business logic
 * Calls DAO methods
 */
public class CustomerService {

    private final CustomerDAO dao = new CustomerDAO();
    private final Scanner sc = new Scanner(System.in);

    // Add new customer
    public void addCustomer() {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Mobile: ");
        String mobile = sc.nextLine();
        System.out.print("City: ");
        String city = sc.nextLine();

        dao.addCustomer(new Customer(0, name, email, mobile, city));
    }

    // Display all customers
    public void showCustomers() {
        List<Customer> list = dao.viewCustomers();
        list.forEach(c ->
                System.out.println(c.getId()+" | "+c.getName()+" | "+
                        c.getEmail()+" | "+c.getMobile()+" | "+c.getCity()));
    }

    // Search customer by ID
    public void searchCustomer() {
        System.out.print("Enter Customer ID: ");
        int id = Integer.parseInt(sc.nextLine());

        Customer c = dao.getCustomerById(id);
        if (c != null)
            System.out.println(c.getId()+" | "+c.getName()+" | "+
                    c.getEmail()+" | "+c.getMobile()+" | "+c.getCity());
        else
            System.out.println("Customer not found");
    }

    // Update mobile number
    public void updateMobile() {
        System.out.print("Customer ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("New Mobile: ");
        String mobile = sc.nextLine();

        System.out.println(
                dao.updateCustomerMobile(id, mobile)
                        ? "Mobile updated successfully"
                        : "Update failed"
        );
    }

    // Delete customer
    public void deleteCustomer() {
        System.out.print("Customer ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.println(
                dao.deleteCustomer(id)
                        ? "Customer deleted"
                        : "Delete failed"
        );
    }

    // Show total number of customers
    public void showCustomerCount() {
        System.out.println("Total Customers: " + dao.getCustomerCount());
    }

    // Show customers based on city
    public void showCustomersByCity() {
        System.out.print("Enter City: ");
        String city = sc.nextLine();

        List<Customer> list = dao.getCustomersByCity(city);
        if (list.isEmpty())
            System.out.println("No customers found");
        else
            list.forEach(c ->
                    System.out.println(c.getId()+" | "+c.getName()));
    }
}
