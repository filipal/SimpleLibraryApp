// Defines the Book class representing a book in the library.
public class Book {
    // Private fields to store the book's title, author, quantity, and initial quantity.
    private String title;
    private String author;
    private int quantity;
    private int initialQuantity; // Added to track the original quantity of the book.

    // Constructor to initialize a new instance of the Book class.
    public Book(String title, String author, int quantity) {
        this.title = title; // Set the title of the book.
        this.author = author; // Set the author of the book.
        this.quantity = quantity; // Set the current available quantity of the book.
        this.initialQuantity = quantity; // Set the initial quantity of the book to track original stock.
    }

    // Getter method for the book's title.
    public String getTitle() {
        return title; // Return the title of the book.
    }

    // Getter method for the book's author.
    public String getAuthor() {
        return author; // Return the author of the book.
    }

    // Getter method for the book's current available quantity.
    public int getQuantity() {
        return quantity; // Return the current quantity of the book.
    }

    // Setter method to update the book's current available quantity.
    public void setQuantity(int quantity) {
        this.quantity = quantity; // Update the quantity of the book.
    }

    // Getter method for the book's initial quantity.
    public int getInitialQuantity() {
        return initialQuantity; // Return the initial quantity of the book.
    }

    // Setter method to update the book's initial quantity.
    // Note: This might not be used frequently but provides flexibility for adjusting stock.
    public void setInitialQuantity(int initialQuantity) {
        this.initialQuantity = initialQuantity; // Update the initial quantity of the book.
    }
}
