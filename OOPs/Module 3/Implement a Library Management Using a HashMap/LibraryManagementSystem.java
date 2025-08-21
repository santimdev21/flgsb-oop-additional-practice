import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;

public class LibraryManagementSystem {
    // Book class to represent book information
    static class Book {
        // Step 1: Declare variables for title, author, genre, and publication year
        // Hint: Use appropriate data types (String for text, int for year)
        private String title;
        private String author;
        private String genre;
        private int publicationYear;
        
        // Step 2: Create a constructor for the Book class
        // Hint: The constructor should take parameters for all book attributes
        public Book(String title, String author, String genre, int publicationYear) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.publicationYear = publicationYear;
        }

        // Step 3: Create getter methods for each attribute
        // Hint: Use the format: public dataType getAttribute()
        public String getTitle() {
            return this.title;
        }
    
        public String getAuthor() {
            return this.author;
        }

        public String getGenre() {
            return this.genre;
        }
    
        public int getPublicationYear() {
            return this.publicationYear;
        }
        
        // Step 4: Create a method to display book details
        // Hint: Return a formatted string with all book information
        public void setTitle(String title) {
            this.title = title;
        }
    
        public void setAuthor(String author) {
            this.author = author;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }
    
        public void setPublicationYear(int publicationYear) {
            this.publicationYear = publicationYear;
        }

        @Override
        public String toString() {
            return this.title + ", " + this.author + ", " + this.genre +  ", " + this.publicationYear;
        }
    }
    
    // Method to validate if the title and author have valid formats
    private static boolean isValidText(String text) {
        // Step 5: Implement validation to ensure text isn't empty
        // Hint: Check if the string is null, empty, or only whitespace

        if(text != null && text.isEmpty() && text.trim().equals("")) {
            return true;
        }

        return false; // Replace this with your implementation
    }
    
    // Method to validate publication year
    private static boolean isValidYear(int year) {
        // Step 6: Implement validation for publication year
        // Hint: Check if the year is reasonable (e.g., between 1000 and current year)
        
        if(1000 <= year && year <= 2025) {
            return true;
        }

        return false; // Replace this with your implementation
    }
    
    public static void main(String[] args) {
        // Step 7: Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);
        
        // Step 8: Create a HashMap to store books (with ISBN as the key)
        var library = new HashMap<Integer, Book>();

        // Step 9: Implement the main loop with menu options
        // Hint: Options should include adding a book, viewing all books, 
        // searching for books, removing a book, viewing sorted books, and exiting

        boolean continueProgram = true; 

        while(continueProgram) {

            System.out.println("1. Add a book" + 
            "\n2. View all books" +
            "\n3. Search for a book by title" +
            "\n4. Remove a book" +
            "\n5. View sorted books" +
            "\nAny other key to Exit");

            int userAction = Integer.parseInt(scanner.nextLine());

            if(userAction == 1) {
                System.out.println("Enter the title of the book: ");
                String title = scanner.nextLine();

                System.out.println("Enter the author of the book: ");
                String author = scanner.nextLine();

                System.out.println("Enter the publication year of the book: ");
                int publicationYear = Integer.parseInt(scanner.nextLine());

                library.add(new Book(title, author, publicationYear));
            } else if(userAction == 2) {
                for(Book index : library) {
                    System.out.println(index);
                }
            } else if(userAction == 3) {
                System.out.println("Enter the title of the book: ");
                String title = scanner.nextLine();

                findBookByTitle(library, title);
            } else if(userAction == 4) {
                System.out.println("Enter the index of the book to check out: ");
                int index = Integer.parseInt(scanner.nextLine());

                if(validIndex(index, library.size())) {
                    System.out.println(library.get(index).checkOut());
                } else {
                    System.out.println("No such index was found");
                }
            } else if(userAction == 5) {
                System.out.println("Enter the index of the book to return: ");
                int index = Integer.parseInt(scanner.nextLine());

                if(validIndex(index, library.size())) {
                    System.out.println(library.get(index).returnBook());
                } else {
                    System.out.println("No such index was found");
                }
            } else {
                continueProgram = false;
            }

        }
        
        // Step 10: Implement the "Add a book" option
        // Hint: Prompt user for book details (ISBN, title, author, genre, year)
        // Validate input and add to the HashMap
        
        // Step 11: Implement the "View all books" option
        // Hint: Iterate through the HashMap and display all books
        
        // Step 12: Implement the "Search for a book" option
        // Hint: Allow searching by ISBN, title or author
        
        // Step 13: Implement the "Remove a book" option
        // Hint: Remove a book from the collection using its ISBN
        
        // Step 14: Implement the "View sorted books" option
        // Hint: Use TreeMap to sort books by title or author
    }
}