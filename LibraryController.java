import java.util.List;
import java.util.Scanner;

public class LibraryController {

    private static LibraryService service = new LibraryService();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addBook(sc);
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    updateBook(sc);
                    break;
                case 4:
                    deleteBook(sc);
                    break;
                case 5:
                    sc.close();
                    System.exit(0);
            }
        }
    }

    public static void addBook(Scanner sc) {
        sc.nextLine();  // Consume newline
        System.out.print("Enter title: ");
        String title = sc.nextLine();
        System.out.print("Enter genre: ");
        String genre = sc.nextLine();
        System.out.print("Enter author: ");
        String author = sc.nextLine();
        System.out.print("Enter status (Available/Issued): ");
        String status = sc.nextLine();
        System.out.print("Enter published date (yyyy-mm-dd): ");
        String publishedDate = sc.nextLine();

        Book book = new Book(0, title, genre, author, status, publishedDate);
        service.addBook(book);
        System.out.println("Book added successfully.");
    }

    public static void viewBooks() {
        List<Book> books = service.getBooks();
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            for (Book book : books) {
                System.out.println(book.getId() + ". " + book.getTitle() + " by " + book.getAuthor());
            }
        }
    }

    public static void updateBook(Scanner sc) {
        System.out.print("Enter book ID to update: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline

        System.out.print("Enter new title: ");
        String title = sc.nextLine();
        System.out.print("Enter new genre: ");
        String genre = sc.nextLine();
        System.out.print("Enter new author: ");
        String author = sc.nextLine();
        System.out.print("Enter new status (Available/Issued): ");
        String status = sc.nextLine();
        System.out.print("Enter new published date (yyyy-mm-dd): ");
        String publishedDate = sc.nextLine();

        Book book = new Book(id, title, genre, author, status, publishedDate);
        service.modifyBook(book);
        System.out.println("Book updated successfully.");
    }

    public static void deleteBook(Scanner sc) {
        System.out.print("Enter book ID to delete: ");
        int id = sc.nextInt();
        service.removeBook(id);
        System.out.println("Book deleted successfully.");
    }
}
