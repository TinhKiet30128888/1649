import java.util.Scanner;

public class LinearSearch {
    public static void searchForBook(String title, Customer customer, AbstractArrayList<Book> books) {
        Scanner scanner = new Scanner(System.in);
        boolean found = false;

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getTitle().equalsIgnoreCase(title)) {
                found = true;
                System.out.println(" ____________________________________________");
                System.out.println("|               Book found:                  |");
                System.out.println("|--------------------------------------------|");
                System.out.println("| Title:        " + book.getTitle());
                System.out.println("| Author:       " + book.getAuthor());
                System.out.println("| Publication Year: " + book.getYear());
                System.out.println("| Price:        $" + book.getPrice());
                System.out.println("|____________________________________________|");
                System.out.println("| Options:                                   |");
                System.out.println("| 1. Add this book to your cart              |");
                System.out.println("| 2. Return to main menu                     |");
                System.out.println("|____________________________________________|");
                System.out.print("Enter your choice: ");
                int option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        System.out.print("Enter the quantity you want to add: ");
                        int quantity = Integer.parseInt(scanner.nextLine());
                        if (quantity <= 0) {
                            System.out.println("Invalid quantity. Returning to main menu.");
                            return;
                        }
                        customer.addToCart(book, quantity);
                        System.out.println("Book added to your cart.");
                        break;
                    case 2:
                        return;
                    default:
                        System.out.println("Invalid option. Returning to main menu.");
                        return;
                }
                break;
            }
        }

        if (!found) {
            System.out.println("Sorry, the book you are searching for is not available.");
        }

    }
}
