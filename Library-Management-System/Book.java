public class Book {

    int bookId;
    String title;
    String author;
    boolean available;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.available = true;
    }
}