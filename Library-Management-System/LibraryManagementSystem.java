import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Book> books = new ArrayList<>();

        int choice;

        do {

            System.out.println("========== LIBRARY MANAGEMENT SYSTEM ==========");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");

            System.out.println("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Enter book ID: ");
                    int bookId = sc.nextInt();

                    boolean bookIdExists = false;

                    for (int i = 0; i < books.size(); i++) {

                        if (books.get(i).bookId == bookId) {
                            bookIdExists = true;
                            break;
                        }
                    }

                    sc.nextLine();

                    System.out.println("Enter book title: ");
                    String title = sc.nextLine();

                    System.out.println("Enter author name: ");
                    String author = sc.nextLine();

                    if (bookIdExists) {
                        System.out.println("Book ID already exists.");
                    } else {
                        Book book = new Book(bookId, title, author);
                        books.add(book);

                        System.out.println("Book added successfully!");
                    }

                    break;

                case 2:
                    if (books.isEmpty()) {
                        System.out.println("No books found.");
                    } else {
                        for (int i=0; i<books.size(); i++) {

                            Book b = books.get(i);

                            System.out.println("Book ID: " + b.bookId);
                            System.out.println("Title: " + b.title);
                            System.out.println("Author: " + b.author);
                            System.out.println("Available: " + b.available);
                            System.out.println("--------------------------");
                        }
                    }

                    break;

                case 3:
                    System.out.println("Enter the book ID to search: ");
                    int searchBookId = sc.nextInt();

                    boolean found = false;

                    for (int i=0; i<books.size(); i++) {
                        Book b = books.get(i);

                        if (b.bookId == searchBookId) {
                            System.out.println("Book found!");
                            System.out.println("Book ID:" + b.bookId);
                            System.out.println("Title: " + b.title);
                            System.out.println("Author: " + b.author);
                            System.out.println("Available: " + b.available);

                            found = true;
                            break;
                        }
                    }

                    if(!found) {
                        System.out.println("Book not found.");
                    }

                    break;


                case 4:
                    System.out.println("Enter the book ID to issue: ");
                    int issueBookId = sc.nextInt();

                    boolean bookFound = false;

                    for (int i=0; i<books.size(); i++) {

                        Book b = books.get(i);

                        if (b.bookId == issueBookId) {

                            bookFound = true;

                            if (b.available) {
                                b.available = false;
                                System.out.println("Book issued successfully!");
                            } else {
                                System.out.println("Book is already issued.");
                            }

                            break;
                        }
                    }

                    if (!bookFound) {
                        System.out.println("Book not found.");
                    }

                    break;

                case 5:
                    System.out.println("Enter the book ID to return: ");
                    int returnBookId = sc.nextInt();

                    boolean returnBookFound = false;

                    for (int i = 0; i < books.size(); i++) {

                        Book b = books.get(i);

                        if (b.bookId == returnBookId) {

                            returnBookFound = true;

                            if (!b.available) {
                                b.available = true;
                                System.out.println("Book returned successfully!");
                            } else {
                                System.out.println("Book is already available.");
                            }

                            break;
                        }
                    }

                    if (!returnBookFound) {
                        System.out.println("Book not found.");
                    }

                    break;

                case 6:
                    System.out.println("Thank you for using the Library Management System!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 6);

        sc.close();
    }
}