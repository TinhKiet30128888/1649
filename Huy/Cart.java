public class Cart {
    private AbstractArrayList<Book> books;
    private AbstractArrayList<Integer> quantities;

    public Cart() {
        this.books = new ArrayListEnhanced<>();
        this.quantities = new ArrayListEnhanced<>();
    }

    public void addBook(Book book, int quantity) {
        int index = books.indexOf(book);
        if (index != -1) {
            int currentQuantity = quantities.get(index);
            quantities.set(index, currentQuantity + quantity);
        } else {
            books.add(book);
            quantities.add(quantity);
        }
    }

    public void removeBook(Book book) {
        int index = books.indexOf(book);
        if (index != -1) {
            books.remove(index);
            quantities.remove(index);
        } else {
            System.out.println("Cannot find book in the cart.");
        }
    }

    public void clearCart() {
        books = new ArrayListEnhanced<>();
        quantities = new ArrayListEnhanced<>();
    }

    public int getTotalBooks() {
        return books.size();
    }

    public AbstractArrayList<Book> getBooks() {
        return this.books;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (int i = 0; i < books.size(); i++) {
            totalPrice += books.get(i).getPrice() * quantities.get(i);
        }
        return totalPrice;
    }

    public AbstractArrayList<Integer> getQuantities() {
        return this.quantities;
    }
}
