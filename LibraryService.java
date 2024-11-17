import java.util.List;

public class LibraryService {

    public void addBook(Book book) {
        BookDAO.createBook(book);
    }

    public List<Book> getBooks() {
        return BookDAO.getAllBooks();
    }

    public void modifyBook(Book book) {
        BookDAO.updateBook(book);
    }

    public void removeBook(int id) {
        BookDAO.deleteBook(id);
    }
}
