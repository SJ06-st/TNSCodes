import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AdminService adminService = new AdminService();
        CustomerService customerService = new CustomerService();
        OrderService orderService = new OrderService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Admin Menu");
            System.out.println("2. Customer Menu");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 1) { // ✅ Admin Menu
                while (true) {
                    System.out.println("\nAdmin Menu:");
                    System.out.println("1. Add Product");
                    System.out.println("2. Remove Product");
                    System.out.println("3. View Products");
                    System.out.println("4. Exit");
                    System.out.print("Choose an option: ");
                    int adminChoice = scanner.nextInt();

                    if (adminChoice == 1) {
                        System.out.print("Enter Product ID: ");
                        int id = scanner.nextInt();
                        System.out.print("Enter Product Name: ");
                        String name = scanner.next();
                        System.out.print("Enter Product Price: ");
                        double price = scanner.nextDouble();
                        System.out.print("Enter Stock Quantity: ");
                        int stock = scanner.nextInt();

                        Product product = new Product(id, name, price, stock);
                        adminService.addProduct(product);
                    } else if (adminChoice == 2) {
                        System.out.print("Enter Product ID to remove: ");
                        int id = scanner.nextInt();
                        adminService.removeProduct(id);
                    } else if (adminChoice == 3) {
                        adminService.viewProducts();
                    } else if (adminChoice == 4) {
                        break; // ✅ Exit Admin Menu
                    }
                }
            } 
            
            else if (choice == 2) { // ✅ Customer Menu
                while (true) {
                    System.out.println("\nCustomer Menu:");
                    System.out.println("1. Create Customer");
                    System.out.println("2. View Customers");
                    System.out.println("3. Place Order");
                    System.out.println("4. View Orders");
                    System.out.println("5. Exit");
                    System.out.print("Choose an option: ");
                    int customerChoice = scanner.nextInt();

                    if (customerChoice == 1) {
                        System.out.print("Enter User ID: ");
                        int userId = scanner.nextInt();
                        System.out.print("Enter Username: ");
                        String username = scanner.next();
                        System.out.print("Enter Email: ");
                        String email = scanner.next();
                        System.out.print("Enter Address: ");
                        String address = scanner.next();

                        customerService.createCustomer(userId, username, email, address);
                    } else if (customerChoice == 2) {
                        customerService.viewCustomers();
                    } else if (customerChoice == 3) {
                        System.out.print("Enter Customer ID: ");
                        int customerId = scanner.nextInt();
                        Customer customer = customerService.getCustomerById(customerId);
                        if (customer != null) {
                            orderService.placeOrder(customer);
                        }
                    } else if (customerChoice == 4) {
                        System.out.print("Enter Customer ID: ");
                        int customerId = scanner.nextInt();
                        Customer customer = customerService.getCustomerById(customerId);
                        if (customer != null) {
                            orderService.viewOrders(customer);
                        }
                    } else if (customerChoice == 5) {
                        break; // ✅ Exit Customer Menu
                    }
                }
            } 
            
            else if (choice == 3) { // ✅ Exit Program
                System.out.println("Exiting...");
                break;
            }
        }
        scanner.close();
    }
}
