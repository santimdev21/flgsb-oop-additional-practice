import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// LibraryManagement class to manage the book collection
public class LibraryManagement {
    public static void main(String[] args) {
        // Step 1: Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        // Step 2: Create an ArrayList to store Book objects
        // Hint: Use ArrayList<Book>
        var library = new ArrayList<Book>();
        boolean continueProgram = true;
        
        // Step 3: Implement a menu-driven program with the following options:
        // 1. Add a book
        // 2. View all books
        // 3. Search for a book by title
        // 4. Check out a book
        // 5. Return a book
        // 6. Sort books (by title, author, or publication year)
        // 7. View available books only
        // 8. Exit
        
        // Step 4: Create the main menu loop
        // Hint: Use a while loop with a boolean flag or a while(true) with a break
        
        // Step 5: Implement case handling for each menu option
        // Hint: Use switch-case or if-else if statements
        
        // Step 6: Implement the addBook functionality
        // Hint: Prompt the user for title, author, and publication year
        
        // Step 7: Implement the viewAllBooks functionality
        // Hint: Use a loop or forEach to display all books
        
        // Step 8: Implement the search functionality
        // Hint: Take user input for search term and check each book
        
        // Step 9: Implement the checkOut functionality
        // Hint: Find the book by index and use the checkOut() method
        
        // Step 10: Implement the returnBook functionality
        // Hint: Find the book by index and use the returnBook() method
        
        // Step 11: Implement the sortBooks functionality
        // Hint: Use Collections.sort() with a Comparator
        
        // Step 12: Implement the viewAvailableBooks functionality
        // Hint: Use ArrayList's stream() or loop through to filter

        while(continueProgram) {

            try {
                System.out.println("1. Add a book" + 
                                    "\n2. View all books" +
                                    "\n3. Search for a book by title" +
                                    "\n4. Check out a book" +
                                    "\n5. Return a book" +
                                    "\n6. Sort books (by title, author, or publication year)" +
                                    "\n7. View available books only" +
                                    "\n8. Exit");

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
                } else if(userAction == 6) {
                    System.out.println("Enter how you want to sort the books: ");
                    System.out.println("1. By title" + 
                                    "\n2. By author" +
                                    "\n3. By publication year" +
                                    "\nAny other number to exit");

                    int sortOption = Integer.parseInt(scanner.nextLine());

                    if(sortOption == 1) {
                        Collections.sort(library, (b1, b2) -> b1.getBookTitle().compareTo(b2.getBookTitle()));
                    } else if(sortOption == 2) {
                        Collections.sort(library, (b1, b2) -> b1.getAuthor().compareTo(b2.getAuthor()));
                    } else if(sortOption == 3) {
                        Collections.sort(library, Comparator.comparingInt(Book::getPublicationYear));
                    }
                } else if(userAction == 7) {
                    for(int i = 0; i < library.size(); i++) {
                        if(library.get(i).getIsAvailable()) {
                            System.out.println(library.get(i));
                        }
                    }
                } else if(userAction == 8) {
                    break;
                }
            } catch(NumberFormatException nfe) {
                System.out.println("Enter a valid number");
            } catch(ArrayIndexOutOfBoundsException iob) {
                System.out.println("Enter a valid index");
            }
        }

        System.out.println("Thank you for using the program");
    }
    
    // Step 13: Create additional helper methods as needed
    // Examples: findBookByTitle(), findBookByIndex(), etc.

    public static void findBookByTitle(ArrayList<Book> library, String title) throws ArrayIndexOutOfBoundsException {
        for(int i = 0; i < library.size(); i++) {
            if(library.get(i).getBookTitle().equalsIgnoreCase(title) && !(library.isEmpty()) ) {
                System.out.println(library.get(i));
            }
        }
    }

    public static void findBookByAuthor(ArrayList<Book> library, String author) throws ArrayIndexOutOfBoundsException {
        for(int i = 0; i < library.size(); i++) {
            if(library.get(i).getAuthor().equalsIgnoreCase(author) && !(library.isEmpty()) ) {
                System.out.println(library.get(i));
            }
        }
    }

    public static void findBookByIndex(ArrayList<Book> library, int index) throws ArrayIndexOutOfBoundsException {
        if(!library.isEmpty()) {
            System.out.println(library.get(index));
        }
    }

    public static boolean validIndex(int index, int length) {
        if(index >= 0 && index < length) {
            return true;
        } else {
            return false;
        }
    }
}