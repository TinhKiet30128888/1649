import java.util.Date;

public class Order {
    private int orderId;
    private AbstractArrayList<Book> books;
    private AbstractArrayList<Integer> quantities;
    private Date orderDate;
    private double totalAmount;
    private String status;
    private String address;

    public Order(int orderId, AbstractArrayList<Book> books, AbstractArrayList<Integer> quantities, Date orderDate,
            String address) {
        this.orderId = orderId;
        this.books = books;
        this.quantities = quantities;
        this.orderDate = orderDate;
        this.status = "wait";
        this.address = address;
        calculateTotalAmount();
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public AbstractArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(AbstractArrayList<Book> books) {
        this.books = books;
        calculateTotalAmount();
    }

    public AbstractArrayList<Integer> getQuantities() {
        return quantities;
    }

    public void setQuantities(AbstractArrayList<Integer> quantities) {
        this.quantities = quantities;
        calculateTotalAmount();
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private void calculateTotalAmount() {
        totalAmount = 0;
        for (int i = 0; i < books.size(); i++) {
            totalAmount += books.get(i).getPrice() * quantities.get(i);
        }
    }

    @Override
    public String toString() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Shipping Address: " + address);
        System.out.println("Books:");
        for (int i = 0; i < books.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + books.get(i).getTitle() + " - Quantity: " + quantities.get(i)
                    + " - Price: $" + books.get(i).getPrice());
        }
        System.out.println("Total Amount: $" + totalAmount);
        return "";
    }

}
