package bank;

import java.util.Scanner;

/*
 * Main class
 * Entry point of the application
 * Displays menu and calls service methods
 */
public class CustomerApp {

    public static void main(String[] args) {

        CustomerService service = new CustomerService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- CUSTOMER MENU ---");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Search Customer by ID");
            System.out.println("4. Update Customer Mobile");
            System.out.println("5. Delete Customer");
            System.out.println("6. Customer Count");
            System.out.println("7. View Customers by City");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> service.addCustomer();
                case 2 -> service.showCustomers();
                case 3 -> service.searchCustomer();
                case 4 -> service.updateMobile();
                case 5 -> service.deleteCustomer();
                case 6 -> service.showCustomerCount();
                case 7 -> service.showCustomersByCity();
                case 8 -> {
                    System.out.println("Thank you!");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }
}
