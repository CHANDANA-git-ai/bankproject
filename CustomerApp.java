package bank;

import java.util.Scanner;

/*
 * Main class
 * Entry point of application
 */
public class CustomerApp {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        CustomerService service = new CustomerService();

        while (true) {
            System.out.println("\n=== SMART BANK MANAGEMENT SYSTEM ===");
            System.out.println("1. Create Account");
            System.out.println("2. View Customers");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Deposit Money");
            System.out.println("6. Withdraw Money");
            System.out.println("7. Exit");
            System.out.print("Choose Option: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> service.createCustomer();
                case 2 -> service.showCustomers();
                case 3 -> service.updateCustomer();
                case 4 -> service.deleteCustomer();
                case 5 -> service.depositMoney();
                case 6 -> service.withdrawMoney();
                case 7 -> {
                    System.out.println("Thank you for using Smart Bank System");
                    return;
                }
                default -> System.out.println("Invalid Choice");
            }
        }
    }
}
