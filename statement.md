# Project Statement

## 1. Problem Statement
Educational institutions and small community libraries often struggle with manual record-keeping, leading to lost resources, inefficient borrowing processes, and a lack of engagement with readers. Existing digital solutions are often too complex or expensive for smaller setups. There is a need for a lightweight, transparent system that not only manages inventory but also actively encourages reading through intelligent suggestions.

## 2. Scope of the Project
The **SmartLibrary** project aims to build a modular, console-based application that acts as a central hub for library operations.
* **In Scope:** User authentication, book inventory management (search, update), transaction handling (borrow/return), and a basic recommendation algorithm. Data persistence is handled via local CSV files.
* **Out of Scope:** Web interface, payment gateway integration, or fine calculation for late returns (planned for future releases).

## 3. Target Users
* **Students/Members:** Individuals looking to search for books, manage their borrowed items, and discover new reading material.
* **Librarians/Administrators:** Users who need to track inventory status and ensure data consistency.
* **Small Libraries:** Community book clubs or school libraries requiring a zero-cost management solution.

## 4. High-Level Features
* **Secure User Onboarding:** Registration and login functionality validation.
* **Dynamic Search Engine:** Ability to filter books by title or author keywords.
* **Transaction Management:** Logic to handle borrowing limits and return updates to prevent data inconsistency.
* **Personalized Experience:** A `RecommendationEngine` that filters catalog data to suggest relevant, available books to the user.
* **Persistence:** Automated loading and saving of state (Users/Books) to CSV files to ensure data survives application restarts.