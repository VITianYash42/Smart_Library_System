package src;

import java.util.Scanner;
import java.util.List;

public class Main {
    private static Library library = new Library();
    private static RecommendationEngine recommender = new RecommendationEngine(library);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Welcome to SmartLibrary ---");
        // Stubbed: Load sample users/books, simple menu
        while (true) {
            System.out.println("1. Register\n2. Login\n3. Exit");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Enter username:");
                String uname = sc.next();
                System.out.println("Enter password:");
                String pwd = sc.next();
                library.addUser(new User(uname, pwd));
                System.out.println("Registration successful.");
            } else if (choice == 2) {
                System.out.println("Enter username:");
                String uname = sc.next();
                System.out.println("Enter password:");
                String pwd = sc.next();
                User user = library.getUser(uname);
                System.out.println(user);
                if (user != null && user.validatePassword(pwd)) {
                    System.out.println("Login successful.");
                    userMenu(user, sc);
                } else {
                    System.out.println("Invalid credentials.");
                }
            } else {
                System.out.println("Goodbye!");
                break;
            }
        }
        sc.close();
    }

    private static void userMenu(User user, Scanner sc) {
        while (true) {
            System.out.println("1. Search Books\n2. Borrow Book\n3. Return Book\n4. Get Recommendations\n5. Logout");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Enter keyword:");
                String kw = sc.next();
                List<Book> found = library.searchBooks(kw);
                for (Book b : found) {
                    System.out.println(b.getId() + ": " + b.getTitle() + " by " + b.getAuthor() + (b.isAvailable() ? " [Available]" : " [Borrowed]"));
                }
                kw = sc.next();
            } else if (choice == 2) {
                System.out.println("Enter book ID to borrow:");
                String bid = sc.next();
                Book book = library.getBook(bid);
                System.out.println(book.isAvailable());
                if (book != null && book.isAvailable()) {
                    user.borrowBook(bid);
                    book.setAvailable(false);
                    System.out.println("Borrowed successfully.");
                } else {
                    System.out.println("Book not available.");
                }
            } else if (choice == 3) {
                System.out.println("Enter book ID to return:");
                String bid = sc.next();
                Book book = library.getBook(bid);
                if (book != null && user.getBorrowedBookIds().contains(bid)) {
                    user.returnBook(bid);
                    book.setAvailable(true);
                    System.out.println("Returned successfully.");
                } else {
                    System.out.println("Invalid operation.");
                }
            } else if (choice == 4) {
                List<Book> recs = recommender.recommendBooks(user);
                System.out.println("Recommended Books:");
                for (Book b : recs) {
                    System.out.println(b.getId() + ": " + b.getTitle() + " by " + b.getAuthor());
                }
            } else if (choice == 5) {
                System.out.println("Logging out...");
                break;
            }
        }
    }
}