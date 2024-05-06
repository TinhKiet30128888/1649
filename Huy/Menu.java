import java.util.Date;
import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        AbstractArrayList<Book> books = new ArrayListEnhanced<>();

        books.add(new Book("The Adventures of Tom Sawyer", "Mark Twain", 1876, 10.99));
        books.add(new Book("A Tale of Two Cities", "Charles Dickens", 1859, 9.99));
        books.add(new Book("The Lion, the Witch and the Wardrobe", "C.S. Lewis", 1950, 8.50));
        books.add(new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", 1979, 12.25));
        books.add(new Book("The Da Vinci Code", "Dan Brown", 2003, 14.75));
        books.add(new Book("Brave New World", "Aldous Huxley", 1932, 11.99));
        books.add(new Book("The Alchemist", "Paulo Coelho", 1988, 7.99));
        books.add(new Book("The Stand", "Stephen King", 1978, 15.50));
        books.add(new Book("The Secret Garden", "Frances Hodgson Burnett", 1911, 6.99));
        books.add(new Book("Wuthering Heights", "Emily Brontë", 1847, 9.25));

        Customer myCustomer = new Customer(1, "Minh Huy");

        menuDisplay(myCustomer, books);
    }

    public static void menuDisplay(Customer user, AbstractArrayList<Book> books) {
        boolean running = true;

        while (running) {
            System.out.println("_____________________________________________");
            System.out.println(" 1. Search for a book");
            System.out.println(" 2. View all available books");
            System.out.println(" 3. View shopping cart");
            System.out.println(" 4. Proceed to checkout");
            System.out.println(" 5. View order history");
            System.out.println(" 6. Exit");
            System.out.println("_____________________________________________");
            
            System.out.print("Enter your userChoice: ");
            int userChoice = Integer.parseInt(scanner.nextLine());

            switch (userChoice) {
                case 1:
                    System.out.print("Enter the title of the book you want to search for: ");
                    String searchTitle = scanner.nextLine();
                    LinearSearch.searchForBook(searchTitle, user, books);
                    break;
                case 2:
                Scanner scanner = new Scanner(System.in);
                AbstractArrayList<Book> tempBookList = new ArrayListEnhanced<>();

                for(int i = 0; i < books.size(); i++) {
                    tempBookList.add(books.get(i));
                }

                boolean sorting = true;

                while (sorting) {
                    System.out.println(" ╔══════════════════════════════════════╗");
                    System.out.println(" ║             All Books:               ║");
                    System.out.println(" ║══════════════════════════════════════║");
                    for (int i = 0; i < tempBookList.size(); i++) {
                        Book book = tempBookList.get(i);
                        System.out.println(" ║ " + (i + 1) + ". Title: " + book.getTitle() + "     ");
                        System.out.println(" ║    Author: " + book.getAuthor() + "                 ");
                        System.out.println(" ║    Publication Year: " + book.getYear() + "         ");
                        System.out.println(" ║    Price: $" + book.getPrice() + "                  ");
                        System.out.println(" ║═════════════════════════════════════════════════════║");
                    }
        
                    // Prompt for user choice
                    System.out.println(" ║ Enter the index of the book to add to  ║");
                    System.out.println(" ║ cart, or 0 to go back:                 ║");
                    System.out.println(" ║    1. Sort by author                   ║");
                    System.out.println(" ║    2. Add a book to cart               ║");
                    System.out.println(" ╚══════════════════════════════════════╝");
                    System.out.print("Enter your choice: ");
                    int userOption;
                    try {
                        userOption = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                        return;
                    }
        
                    if (userOption == 0) {
                        sorting = false;
                    } else if (userOption == 1) {
                        SelectionSort.sortBooksByAuthor(tempBookList);
                        System.out.println("Books sorted by author.");
                    } else if (userOption == 2) {
                        System.out.print("Enter the index of the book to add to cart: ");
                        int bookIndex;
                        try {
                            bookIndex = Integer.parseInt(scanner.nextLine());
                            if (bookIndex >= 1 && bookIndex <= tempBookList.size()) {
                                System.out.print("Enter the quantity: ");
                                int quantity = Integer.parseInt(scanner.nextLine());
                                if (quantity <= 0) {
                                    System.out.println("Invalid quantity. Returning to main menu.");
                                    return;
                                }
                                user.addToCart(tempBookList.get(bookIndex - 1), quantity);
                                System.out.println("Book added to cart successfully!");
                            } else {
                                System.out.println("Invalid book index!");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                        }
                    } else {
                        System.out.println("Invalid choice!");
                    }
                }
            
                    break;
                case 3:
                    displayCart(user);
                    break;
                case 4:
                    checkout(user);
                    break;
                case 5:
                    Queue<Order> orderQueue = user.getOrderQueue();

                    System.out.println("****************************************");
                    System.out.println("*             Your Orders              *");
                    System.out.println("****************************************");
            
                    if (orderQueue.isEmpty()) {
                        System.out.println("No orders found.");
                    } else {
                        AbstractArrayList<Order> orderList = orderQueue.toList();
                        for (int i = 0; i < orderList.size(); i++){
                            System.out.println(orderList.get(i));
                        }
                    }
            
                    System.out.println("****************************************");
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid userChoice. Please try again!");
                    break;
            }
        }
    }



    public static void displayCart(Customer user) {
        Cart cart = user.getCart();
        AbstractArrayList<Book> booksInCart = cart.getBooks();

        System.out.println("Books in Cart:");
        for (int i = 0; i < booksInCart.size(); i++) {
            Book book = booksInCart.get(i);
            System.out.println((i + 1) + ". Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
                    ", Publication Year: " + book.getYear() + ", Price: $" + book.getPrice());
        }

        System.out.println("Total Price: $" + cart.getTotalPrice());
        System.out.println("Options:");
        System.out.println("1. Remove a book from the cart");
        System.out.println("2. Checkout");
        System.out.println("3. Return to main menu");
        System.out.print("Enter your choice: ");
        int option = Integer.parseInt(scanner.nextLine());
        switch (option) {
            case 1:
                System.out.print("Enter the index of the book to remove: ");
                int indexToRemove = Integer.parseInt(scanner.nextLine());
                if (indexToRemove >= 1 && indexToRemove <= booksInCart.size()) {
                    user.removeFromCart(booksInCart.get(indexToRemove - 1));
                    System.out.println("Book removed from cart successfully!");
                } else {
                    System.out.println("Invalid book index!");
                }
                break;
            case 2:
                checkout(user);
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid option. Returning to main menu.");
                break;
        }
    }


    public static void checkout(Customer user) {
        Cart cart = user.getCart();
        if (cart.getTotalBooks() != 0) {
            System.out.print("Enter your shipping address: ");
            String shippingAddress = scanner.nextLine();
            Order order = new Order(user.getOrderQueue().size() + 1, cart.getBooks(), cart.getQuantities(), new Date(), shippingAddress);
            user.addOrder(order);
            cart.clearCart();
            System.out.println("Thank you for your order!");
        } else {
            System.out.println("Your cart is empty. Add some items before checking out.");
        }
    }
}
