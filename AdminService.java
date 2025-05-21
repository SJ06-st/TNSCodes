import java.util.ArrayList;
import java.util.List;

class AdminService {
    private List<Product> products = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added successfully!");
    }

    public void removeProduct(int productId) {
        products.removeIf(p -> p.getProductId() == productId);
        System.out.println("Product removed successfully!");
    }

    public void updateOrderStatus(int orderId, String newStatus) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                order.updateStatus(newStatus);
                System.out.println("Order status updated!");
                return;
            }
        }
        System.out.println("Order not found.");
    }

    public void viewProducts() {
        for (Product product : products) {
            System.out.println("Product ID: " + product.getProductId() + ", Name: " + product.getName());
        }
    }
}
