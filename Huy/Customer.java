public class Customer {
    private int customerId;
    private String name;
    private Cart cart;
    private Queue<Order> orderQueue;

    public Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.cart = new Cart();
        this.orderQueue = new Queue<>();
    }

    public void addToCart(Book book, int quantity) {
        cart.addBook(book, quantity);
    }

    public void removeFromCart(Book book) {
        cart.removeBook(book);
    }

    public void clearCart() {
        cart.clearCart();
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public Cart getCart() {
        return cart;
    }
    

    public Queue<Order> getOrderQueue() {
        return orderQueue;
    }
    public void addOrder(Order order) {
        orderQueue.offer(order);
    }
}

