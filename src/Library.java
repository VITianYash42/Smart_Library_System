package src;

import java.util.*;
import java.io.*;

public class Library {
    private Map<String, Book> books;
    private Map<String, User> users;

    public Library() {
        books = new HashMap<>();
        users = new HashMap<>();

        String csvFile = "data_books.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            boolean first = true;
            while ((line = br.readLine()) != null) {
                if (first) { first = false; continue; } // skip header
                String[] parts = line.split(",");
                if (parts.length < 4) continue;
                String id = parts[0].trim();
                String title = parts[1].trim();
                String author = parts[2].trim();
                boolean isAvailable = Boolean.parseBoolean(parts[3].trim());
                books.put(id, new Book(id, title, author, isAvailable));
            }
        } catch (IOException e) {
            System.err.println("Failed to load books from " + csvFile + ": " + e.getMessage());
        }

        // load users from CSV
        String usersCsv = "data_users.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(usersCsv))) {
            String line;
            boolean firstUser = true;
            while ((line = br.readLine()) != null) {
                if (firstUser) { firstUser = false; continue; } // skip header
                String[] parts = line.split(",");
                if (parts.length < 2) continue;
                String username = parts[0].trim();
                String password = parts[1].trim();
                users.put(username, new User(username, password));
            }
        } catch (IOException e) {
            System.err.println("Failed to load users from " + usersCsv + ": " + e.getMessage());
        }
    }

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    public Book getBook(String id) {
        return books.get(id);
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public List<Book> searchBooks(String keyword) {
        List<Book> result = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())
                || book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }
}