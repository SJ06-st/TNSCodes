import java.util.List;

class Order {
    private static int orderCounter = 1;
    private int orderId;
    private Customer customer;
    private List<Product> products;
    private String status;

    public Order(Customer customer, List<Product> products) {
        this.orderId = orderCounter++;
        this.customer = customer;
        this.products = products;
        this.status = "Pending";
    }

    public int getOrderId() { return orderId; }
    public Customer getCustomer() { return customer; }
    public List<Product> getProducts() { return products; }
    public String getStatus() { return status; }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }
}
