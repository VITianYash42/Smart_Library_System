package src;

import java.util.*;

public class User {
    private String username;
    private String password;
    private List<String> borrowedBookIds;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.borrowedBookIds = new ArrayList<>();
    }

    public String getUsername() { return username; }
    public boolean validatePassword(String input) { return password.equals(input); }
    public List<String> getBorrowedBookIds() { return borrowedBookIds; }

    public void borrowBook(String bookId) { borrowedBookIds.add(bookId); }
    public void returnBook(String bookId) { borrowedBookIds.remove(bookId); }
}