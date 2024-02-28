import java.util.Scanner;
import java.util.InputMismatchException;

// Defines the LibrarySystem class that manages a collection of books.
public class LibrarySystem {
    // Array to store the books in the library. Assumes a maximum of 5 books for simplicity.
    private Book[] books = new Book[5];
    // Counter to keep track of the number of books currently added to the library.
    private int bookCount = 0;

    // Method to add a new book to the library or update the quantity of an existing one.
    public void addBook(String title, String author, int quantity) {
        // Iterate over the array of books to check if the book already exists.
        for (int i = 0; i < bookCount; i++) {
            // If a book with the same title exists, update its quantity.
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                books[i].setQuantity(books[i].getQuantity() + quantity);
                System.out.println("Quantity of book '" + title + "' updated.");
                return; // Exit the method after updating the quantity.
            }
        }

        // Validate the author's name to ensure it contains at least one alphabet letter.
        if (!author.matches(".*[a-zA-Z]+.*")) {
            System.out.println("Author must contain at least one letter.");
            return; // Exit the method if the author's name is invalid.
        }

        // Check if there's space to add a new book.
        if (bookCount < books.length) {
            // Add the new book to the array and increment the book count.
            books[bookCount++] = new Book(title, author, quantity);
            System.out.println("Book added: " + title + ", Quantity: " + quantity);
        } else {
            // Notify the user if there's no space left to add new books.
            System.out.println("No more space for adding new books.");
        }
    }

    // Method to borrow a book from the library.
    public void borrowBook(String title, int quantity) {
        // Iterate over the array of books to find the book to borrow.
        for (int i = 0; i < bookCount; i++) {
            // Check if the book is available and has enough copies to borrow.
            if (books[i].getTitle().equalsIgnoreCase(title) && books[i].getQuantity() >= quantity) {
                // Reduce the quantity of the book by the borrowed amount.
                books[i].setQuantity(books[i].getQuantity() - quantity);
                System.out.println("You've borrowed " + quantity + " copies of the book '" + title + "'.");
                return; // Exit the method after borrowing the book.
            }
        }
        // Notify the user if the book is not available or does not have enough copies.
        System.out.println("The book '" + title + "' is not available or does not have enough copies.");
    }

    // Method to return a borrowed book to the library.
    public void returnBook(String title, int quantity) {
        boolean bookReturned = false;
        // Iterate over the array of books to find the book to return.
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                // Calculate the new quantity after returning the books.
                int newQuantity = books[i].getQuantity() + quantity;
                // Ensure that the user is not returning more books than they borrowed.
                if (newQuantity > books[i].getInitialQuantity()) {
                    System.out.println("You can't return more books than borrowed.");
                    return; // Exit the method if the returned quantity is too high.
                }
                // Update the book's quantity with the returned books.
                books[i].setQuantity(newQuantity);
                System.out.println("You've returned " + quantity + " copies of the book '" + title + "'.");
                bookReturned = true;
                break; // Exit the loop once the book is returned.
            }
        }

        // Notify the user if the book does not belong to the library.
        if (!bookReturned) {
            System.out.println("The book '" + title + "' does not belong to our library.");
        } else {
            // If the book was successfully returned, display the currently loaned books.
            displayCurrentLoans();
        }
    }

    // Method to display books that are currently loaned out.
    public void displayCurrentLoans() {
        System.out.println("Currently loaned books:");
        // Iterate over the array of books to find and display loaned books.
        for (int i = 0; i < bookCount; i++) {
            // Check if any copies of the book are currently loaned out.
            if (books[i].getQuantity() < books[i].getInitialQuantity()) {
                // Display the title and the number of copies currently loaned.
                System.out.println("- " + books[i].getTitle() + ": " +
                        (books[i].getInitialQuantity() - books[i].getQuantity()) +
                        " copies currently loaned.");
            }
        }
    }
}
