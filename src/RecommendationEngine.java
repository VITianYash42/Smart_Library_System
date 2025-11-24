package src;

import java.util.*;

public class RecommendationEngine {
    private Library library;

    public RecommendationEngine(Library library) {
        this.library = library;
    }

    public List<Book> recommendBooks(User user) {
        // Simple stub: Recommend books not yet borrowed
        List<Book> recommendations = new ArrayList<>();
        for (Book book : library.searchBooks("")) {
            if (!user.getBorrowedBookIds().contains(book.getId()) && book.isAvailable()) {
                recommendations.add(book);
            }
        }
        // Limit to top 5
        return recommendations.size() > 5 ? recommendations.subList(0, 5) : recommendations;
    }
}