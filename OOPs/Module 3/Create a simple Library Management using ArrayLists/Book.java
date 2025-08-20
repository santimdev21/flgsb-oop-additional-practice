// Book class to represent a library book
public class Book {
    // Step 1: Declare private variables for bookTitle, author, publicationYear, and isAvailable
    // Hint: Use appropriate data types (String for title/author, int for year, boolean for availability)
    private String bookTitle;
    private String author;
    private int publicationYear;
    private boolean isAvailable;

    // Step 2: Create a constructor that accepts bookTitle, author, and publicationYear
    // Hint: Initialize all fields including setting isAvailable to true by default
    public Book(String bookTitle, String author, int publicationYear) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isAvailable = true;
    }

    // Step 3: Create public getter methods for each variable
    // Hint: Use the format: public returnType getVariableName()
    public String getBookTitle() {
        return this.bookTitle;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getPublicationYear() {
        return this.publicationYear;
    }

    public boolean getIsAvailable() {
        return this.isAvailable;
    }
    
    // Step 4: Create public setter methods for relevant variables
    // Hint: You might not need setters for all variables
    public void setBookTilte(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    
    // Step 5: Create methods to check out and return a book
    // checkOut() method should set isAvailable to false and return true if the book was available
    // returnBook() method should set isAvailable to true and return true if the book was checked out
    public boolean checkOut() {
        boolean wasAvailable = this.isAvailable;
        this.isAvailable = false;

        if(wasAvailable) {
            return true;
        } else {
            return false;
        }
    }

    public boolean returnBook() {
        boolean wasCheckedOut = this.isAvailable;
        this.isAvailable = true;

        if(!wasCheckedOut) {
            return true;
        } else {
            return false;
        }
    }

    // Step 6: Override toString() method to display book details
    // Hint: Show title, author, year, and availability status
    @Override
    public String toString() {
        return "Title: " + this.bookTitle + "\nAuthor: " + this.author +
                "\nYear: " + this.publicationYear + "\nIs available: " + this.isAvailable;
    }
}