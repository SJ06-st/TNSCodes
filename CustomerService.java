import java.util.ArrayList;
import java.util.List;

class CustomerService {
    private List<Customer> customers = new ArrayList<>();

    public void createCustomer(int userId, String username, String email, String address) {
        Customer newCustomer = new Customer(userId, username, email, address);
        customers.add(newCustomer);
        System.out.println("Customer created successfully!");
    }

    public void viewCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }
        System.out.println("Customers:");
        for (Customer c : customers) {
            System.out.println("User ID: " + c.getUserId() + ", Username: " + c.getUsername() + ", Email: " + c.getEmail() + ", Address: " + c.getAddress());
        }
    }

    public Customer getCustomerById(int userId) {
        for (Customer c : customers) {
            if (c.getUserId() == userId) {
                return c;
            }
        }
        System.out.println("Customer not found!");
        return null;
    }
}
