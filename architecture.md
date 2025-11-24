# 🏗️ System Architecture

The **SmartLibrary** system is built on a **Modular Layered Architecture**, separating the user interface (CLI) from the core business logic and data management. This design ensures maintainability, scalability, and ease of testing.

## 1. High-Level Architecture
The application follows a standard **Input-Process-Output** flow, structured into three distinct layers:

1.  **Presentation Layer (`Main.java`)**: Handles all user interaction, menu display, and input validation.
2.  **Logic Layer (`Library.java`, `RecommendationEngine.java`)**: Contains the core functionality for managing inventory, authenticating users, and generating recommendations.
3.  **Data Layer (`User.java`, `Book.java`, CSV Files)**: Defines the data models and handles persistent storage via file I/O.

---

## 2. Class Diagram
The following diagram illustrates the relationships between the classes. The `Library` class acts as the central controller for data, while `Main` drives the application flow.

```mermaid
classDiagram
    class Main {
        +main(args)
        +userMenu(User, Scanner)
    }

    class Library {
        -Map books
        -Map users
        +Library()
        +searchBooks(keyword)
        +borrowBook(id)
        +returnBook(id)
    }

    class RecommendationEngine {
        -Library library
        +recommendBooks(User)
    }

    class User {
        -String username
        -String password
        -List borrowedBookIds
        +borrowBook(bookId)
        +returnBook(bookId)
    }

    class Book {
        -String id
        -String title
        -String author
        -boolean isAvailable
    }

    Main --> Library : Uses
    Main --> RecommendationEngine : Uses
    RecommendationEngine --> Library : Reads Data
    Library "1" *-- "*" Book : Manages
    Library "1" *-- "*" User : Manages