import java.util.InputMismatchException;
import java.util.Scanner;

// Defines a class named SimpleLibraryApp which serves as the entry point to a simple library management system.
public class SimpleLibraryApp {
    // The main method where the program execution begins.
    public static void main(String[] args) {
        // Create a Scanner object to read input from the console.
        Scanner scanner = new Scanner(System.in);
        // Instantiate the LibrarySystem to manage books.
        LibrarySystem library = new LibrarySystem();

        // Infinite loop to keep the program running until the user decides to exit.
        while (true) {
            // Displaying options to the user.
            System.out.println("Select an option:");
            System.out.println("1 - Add a book");
            System.out.println("2 - Borrow a book");
            System.out.println("3 - Return a book");
            System.out.println("4 - Exit");

            int choice;
            try {
                // Attempt to read the user's choice as an integer.
                choice = scanner.nextInt();
                scanner.nextLine(); // Clear the buffer to avoid input issues after reading an integer.
            } catch (InputMismatchException e) {
                // Handle cases where the input is not an integer.
                System.out.println("Please enter a numerical value.");
                scanner.next(); // Clear invalid input before continuing.
                continue; // Skip the rest of the loop iteration and prompt the user again.
            }

            // Decision making based on the user's choice.
            switch (choice) {
                case 1:
                    // Call the method to add a book to the library.
                    addBook(scanner, library);
                    break;
                case 2:
                    // Call the method to borrow a book from the library.
                    borrowBook(scanner, library);
                    break;
                case 3:
                    // Call the method to return a book to the library.
                    returnBook(scanner, library);
                    break;
                case 4:
                    // Exit the program.
                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;
                default:
                    // Handle any input that doesn't match the expected choices.
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    // Method to add a book to the library.
    private static void addBook(Scanner scanner, LibrarySystem library) {
        // Prompt the user for the book title and ensure it's not empty.
        String title = "";
        while (title.isEmpty()) {
            System.out.print("Enter the book title: ");
            title = scanner.nextLine();
            if (title.isEmpty()) {
                System.out.println("The book title cannot be empty. Please try again.");
            }
        }

        // Prompt for the author's name in a similar manner, ensuring it's not empty.
        String author = "";
        while (author.isEmpty()) {
            System.out.print("Enter the author's name: ");
            author = scanner.nextLine();
            if (author.isEmpty()) {
                System.out.println("The author's name cannot be empty. Please try again.");
            }
        }

        // Prompt for the quantity of books being added, ensuring it's a positive integer.
        int quantity = 0;
        boolean validQuantity = false;
        while (!validQuantity) {
            System.out.print("Enter the quantity: ");
            try {
                quantity = Integer.parseInt(scanner.nextLine());
                if (quantity <= 0) {
                    System.out.println("The quantity must be greater than 0. Please try again.");
                } else {
                    validQuantity = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. The quantity must be a numerical value. Please try again.");
            }
        }

        // Add the book to the library with the given title, author, and quantity.
        library.addBook(title, author, quantity);
    }
    // Method to borrow a book from the library. It prompts the user for the book's title and quantity.
    private static void borrowBook(Scanner scanner, LibrarySystem library) {
        // Initialize a String to hold the book title, ensuring it starts empty.
        String title = "";
        // Continue prompting the user until a non-empty title is entered.
        while (title.isEmpty()) {
            System.out.print("Enter the title of the book you wish to borrow: ");
            title = scanner.nextLine();
            // If the user enters an empty string, inform them of the mistake and prompt again.
            if (title.isEmpty()) {
                System.out.println("The book title cannot be empty. Please try again.");
            }
        }

        // Initialize quantity to 0 and a flag to check for valid quantity input.
        int quantity = 0;
        boolean validQuantity = false;
        // Prompt for the quantity to borrow until a valid positive integer is provided.
        while (!validQuantity) {
            System.out.print("Enter the quantity to borrow: ");
            try {
                // Parse the quantity input as an integer.
                quantity = Integer.parseInt(scanner.nextLine());
                // Check if the quantity is greater than 0; if not, prompt again.
                if (quantity <= 0) {
                    System.out.println("The quantity must be greater than 0. Please try again.");
                } else {
                    // If the quantity is valid, set the flag to true to exit the loop.
                    validQuantity = true;
                }
            } catch (NumberFormatException e) {
                // Handle non-integer inputs by informing the user and prompting again.
                System.out.println("Invalid input. The quantity must be a numerical value. Please try again.");
            }
        }

        // Call the library system's method to borrow the specified quantity of the book.
        library.borrowBook(title, quantity);
    }

    // Method to return a book to the library. It requires the user to specify the book title and the quantity being returned.
    private static void returnBook(Scanner scanner, LibrarySystem library) {
        // Prompt the user for the title of the book they're returning.
        System.out.print("Enter the title of the book you are returning: ");
        String title = scanner.nextLine();
        // If the title input is empty, notify the user and exit the method early.
        if (title.isEmpty()) {
            System.out.println("The book title cannot be empty. Please try again.");
            return;
        }

        // Prompt for the quantity of books being returned.
        System.out.print("Enter the quantity of books you are returning: ");
        int quantity;
        try {
            // Parse the entered quantity as an integer.
            quantity = Integer.parseInt(scanner.nextLine());
            // Ensure the quantity is a positive number; if not, prompt again and exit the method early.
            if (quantity <= 0) {
                System.out.println("The quantity must be greater than 0. Please try again.");
                return;
            }
        } catch (NumberFormatException e) {
            // Handle non-integer inputs by informing the user and exiting the method early.
            System.out.println("Invalid input. The quantity must be a numerical value. Please try again.");
            return;
        }

        // Call the library system's method to return the specified quantity of the book.
        library.returnBook(title, quantity);
    }
}
