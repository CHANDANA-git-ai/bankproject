package bank;

import java.util.Scanner;

/*
 * Service layer
 * Contains business logic and user interaction
 */
public class CustomerService {

    CustomerDAO dao = new CustomerDAOImpl();
    Scanner sc = new Scanner(System.in);

    // Create customer
    public void createCustomer() throws Exception {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Mobile: ");
        String mobile = sc.nextLine();
        System.out.print("City: ");
        String city = sc.nextLine();
        System.out.print("Initial Balance: ");
        double bal = Double.parseDouble(sc.nextLine());

        dao.addCustomer(new CustomerDTO(name, email, mobile, city, bal));
        System.out.println("Account Created Successfully");
    }

    // View customers
    public void showCustomers() throws Exception {
        dao.viewCustomers();
    }

    // Update customer
    public void updateCustomer() throws Exception {
        System.out.print("Customer ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("New Name: ");
        String name = sc.nextLine();
        System.out.print("New Email: ");
        String email = sc.nextLine();
        System.out.print("New Mobile: ");
        String mobile = sc.nextLine();
        System.out.print("New City: ");
        String city = sc.nextLine();

        CustomerDTO c = new CustomerDTO();
        c.setId(id);
        c.setName(name);
        c.setEmail(email);
        c.setMobile(mobile);
        c.setCity(city);

        System.out.println(
            dao.updateCustomer(c) ? "Customer Updated Successfully" : "Customer Not Found"
        );
    }

    // Delete customer
    public void deleteCustomer() throws Exception {
        System.out.print("Customer ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.println(
            dao.deleteCustomer(id) ? "Customer Deleted Successfully" : "Customer Not Found"
        );
    }

    // Deposit
    public void depositMoney() throws Exception {
        System.out.print("Customer ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Amount: ");
        double amt = Double.parseDouble(sc.nextLine());

        System.out.println(
            dao.deposit(id, amt) ? "Deposit Successful" : "Deposit Failed"
        );
    }

    // Withdraw
    public void withdrawMoney() throws Exception {
        System.out.print("Customer ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Amount: ");
        double amt = Double.parseDouble(sc.nextLine());

        System.out.println(
            dao.withdraw(id, amt) ? "Withdrawal Successful" : "Insufficient Balance"
        );
    }
}
