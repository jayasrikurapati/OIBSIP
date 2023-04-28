import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean available;

    public Book(String title, String author, String isbn, boolean available) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = available;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Book> searchByTitle(String title) {
        ArrayList<Book> results = new ArrayList<Book>();
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                results.add(book);
            }
        }
        return results;
    }

    public ArrayList<Book> searchByAuthor(String author) {
        ArrayList<Book> results = new ArrayList<Book>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                results.add(book);
            }
        }
        return results;
    }

    public Book searchByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public ArrayList<Book> searchByAvailability(boolean available) {
        ArrayList<Book> results = new ArrayList<Book>();
        for (Book book : books) {
            if (book.isAvailable() == available) {
                results.add(book);
            }
        }
        return results;
    }
}

public class DigitalLibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Add sample books to the library
        Book book1 = new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", "9780345391803", true);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "9780446310789", true);
        Book book3 = new Book("1984", "George Orwell", "9780451524935", false);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Menu loop
        while (true) {
            System.out.println("Welcome to the Digital Library System!");
            System.out.println("1. Search for books by title");
            System.out.println("2. Search for books by author");
            System.out.println("3. Search for books by ISBN");
            System.out.println("4. Search for available books");
            System.out.println("5. Check out a book");
            System.out.println("6. Return a book");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    ArrayList<Book> resultsByTitle = library.searchByTitle(title);
                    if (resultsByTitle.isEmpty()) {
                        System.out.println("No books found with that title.");
} else {
System.out.println("Results:");
for (Book book : resultsByTitle) {
System.out.println(book.getTitle() + " by " + book.getAuthor() + ", ISBN: " + book.getIsbn() + ", Available: " + book.isAvailable());
}
}
break;
            case 2:
                System.out.print("Enter author: ");
                String author = scanner.nextLine();
                ArrayList<Book> resultsByAuthor = library.searchByAuthor(author);
                if (resultsByAuthor.isEmpty()) {
                    System.out.println("No books found by that author.");
                } else {
                    System.out.println("Results:");
                    for (Book book : resultsByAuthor) {
                        System.out.println(book.getTitle() + " by " + book.getAuthor() + ", ISBN: " + book.getIsbn() + ", Available: " + book.isAvailable());
                    }
                }
                break;

            case 3:
                System.out.print("Enter ISBN: ");
                String isbn = scanner.nextLine();
                Book resultByIsbn = library.searchByIsbn(isbn);
                if (resultByIsbn == null) {
                    System.out.println("No books found with that ISBN.");
                } else {
                    System.out.println("Result:");
                    System.out.println(resultByIsbn.getTitle() + " by " + resultByIsbn.getAuthor() + ", ISBN: " + resultByIsbn.getIsbn() + ", Available: " + resultByIsbn.isAvailable());
                }
                break;

            case 4:
                System.out.print("Search for available books only? (y/n): ");
                String input = scanner.nextLine();
                boolean availableOnly = input.equalsIgnoreCase("y");
                ArrayList<Book> resultsByAvailability = library.searchByAvailability(availableOnly);
                if (resultsByAvailability.isEmpty()) {
                    System.out.println("No books found.");
                } else {
                    System.out.println("Results:");
                    for (Book book : resultsByAvailability) {
                        System.out.println(book.getTitle() + " by " + book.getAuthor() + ", ISBN: " + book.getIsbn() + ", Available: " + book.isAvailable());
                    }
                }
                break;

            case 5:
                System.out.print("Enter ISBN of book to check out: ");
                String isbnToCheckOut = scanner.nextLine();
                Book bookToCheckOut = library.searchByIsbn(isbnToCheckOut);
                if (bookToCheckOut == null) {
                    System.out.println("No books found with that ISBN.");
                } else if (!bookToCheckOut.isAvailable()) {
                    System.out.println("Book is not available.");
                } else {
                    bookToCheckOut.setAvailable(false);
                    System.out.println("Book checked out successfully.");
                }
                break;

            case 6:
                System.out.print("Enter ISBN of book to return: ");
                String isbnToReturn = scanner.nextLine();
                Book bookToReturn = library.searchByIsbn(isbnToReturn);
                if (bookToReturn == null) {
                    System.out.println("No books found with that ISBN.");
                } else if (bookToReturn.isAvailable()) {
                    System.out.println("Book is already available.");
                } else {
                    bookToReturn.setAvailable(true);
                    System.out.println("Book returned successfully.");
                }
                break;

            case 0:
                System.out.println("Exiting...");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid choice. Please enter a number from 0 to 6.");
        }
    }
}

