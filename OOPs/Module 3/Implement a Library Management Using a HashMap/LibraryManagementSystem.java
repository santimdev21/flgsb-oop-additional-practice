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
    private static String validateText(String printMessage, Scanner scanner) {
        // Step 5: Implement validation to ensure text isn't empty
        // Hint: Check if the string is null, empty, or only whitespace
        String text;
    
        while(true) {
            System.out.println(printMessage);

            text = scanner.nextLine();

            if(text.equalsIgnoreCase("/exit")) {
                return null;
            } else if(text != null && !text.isEmpty() && !(text.trim().equals("")) ) {
                break;
            } else {
                System.out.println("Enter a valid text");
            }
        }

        return text; // Replace this with your implementation
    }
    
    // Method to validate publication year
    private static int validateYear(String printMessage, Scanner scanner) {
        // Step 6: Implement validation for publication year
        // Hint: Check if the year is reasonable (e.g., between 1000 and current year)
        int year;

        while(true) {
            System.out.println(printMessage);

            year = Integer.parseInt(scanner.nextLine());

            if(year == 111) {
                return 0;
            } else if(1000 <= year && year <= 2025) {
                break;
            } else {
                System.out.println("Enter a valid year");
            }
        }

        return year; // Replace this with your implementation
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

            try {
                System.out.println("1. Add a book" + 
                "\n2. View all books" +
                "\n3. Search for a book by title" +
                "\n4. Remove a book" +
                "\n5. View sorted books" +
                "\nAny other key to Exit");

                String userAction = scanner.nextLine();

                if(userAction.equals("1")) {
                    System.out.println("Enter the ISBN of the book: ");
                    int ISBN = Integer.parseInt(scanner.nextLine());

                    String title = validateText("Enter the title of the book: ", scanner);

                    String author = validateText("Enter the author of the book: ", scanner);

                    String genre = validateText("Enter the genre of the book: ", scanner);

                    int publicationYear = validateYear("Enter the publication year of the book:", scanner);

                    library.put(ISBN, new Book(title, author, genre, publicationYear));

                    System.out.println("Book added.");
                } else if(userAction.equals("2")) {
                    for(Map.Entry<Integer, Book> entry : library.entrySet()) {
                        System.out.println(entry.getKey() + ", " + entry.getValue());
                    }
                } else if(userAction.equals("3")) {
                    String title = validateText("Enter the title of the book to search: ", scanner);

                    for(Map.Entry<Integer, Book> entry : library.entrySet()) {
                        if(entry.getValue().getTitle().equals(title)) {
                            System.out.println(entry.getKey() + ", " + entry.getValue());
                        }
                    }
                } else if(userAction.equals("4")) {
                    System.out.println("Enter the ISBN of the book to delete: ");
                    int ISBN = Integer.parseInt(scanner.nextLine());

                    library.remove(ISBN);
                } else if(userAction.equals("5")) {
                    System.out.println("Do you want to sort book by title or author?");
                    System.out.println("1. Title" + "\n2. Author" + "\n3. Any other key to exit");
                    int option = Integer.parseInt(scanner.nextLine());

                    var orderedLibrary = new TreeMap<Integer, Book>(library);

                    if(option == 1) {

                        for(Map.Entry<Integer, Book> entry : orderedLibrary.entrySet()) {
                            System.out.println(entry.getValue().getTitle() + ", " + entry.getKey() + ", " + 
                                            entry.getValue().getAuthor() + ", " + entry.getValue().getPublicationYear() + ", " +
                                            entry.getValue().getPublicationYear());
                        }
                    } else if(option == 2) {

                        for(Map.Entry<Integer, Book> entry : orderedLibrary.entrySet()) {
                            System.out.println(entry.getValue().getAuthor() + ", " + entry.getKey() + ", " + 
                                            entry.getValue().getTitle() + ", " + entry.getValue().getPublicationYear() + ", " +
                                            entry.getValue().getPublicationYear());
                        }
                    }
                } else {
                    continueProgram = false;
                }
            } catch(NumberFormatException nfe) {
                System.out.println("Enter a valid number");
            } catch(ArrayIndexOutOfBoundsException iobe) {
                System.out.println("Enter a valid index");
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