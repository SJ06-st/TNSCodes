import java.util.ArrayList;
import java.util.List;

class OrderService {
    private List<Order> orders = new ArrayList<>();

    public void placeOrder(Customer customer) {
        if (customer == null) {
            System.out.println("Invalid customer.");
            return;
        }

        if (customer.getShoppingCart().getItems().isEmpty()) {
            System.out.println("Shopping cart is empty! Add products before placing an order.");
            return;
        }

        Order newOrder = new Order(customer, new ArrayList<>(customer.getShoppingCart().getItems().keySet()));
        orders.add(newOrder);
        customer.getOrders().add(newOrder);
        customer.getShoppingCart().clearCart();
        System.out.println("Order placed successfully! Order ID: " + newOrder.getOrderId());
    }

    public void viewOrders(Customer customer) {
        if (customer == null) {
            System.out.println("Invalid customer.");
            return;
        }

        if (customer.getOrders().isEmpty()) {
            System.out.println("No orders found for this customer.");
            return;
        }

        System.out.println("Orders for " + customer.getUsername() + ":");
        for (Order order : customer.getOrders()) {
            System.out.println("Order ID: " + order.getOrderId() + ", Status: " + order.getStatus());
            for (Product product : order.getProducts()) {
                System.out.println("  - " + product.getName() + " (₹" + product.getPrice() + ")");
            }
        }
    }
}
