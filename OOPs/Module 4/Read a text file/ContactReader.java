// ContactReader.java
// This program reads contact information from a file and displays it in a formatted way

// Step 1: Import necessary packages for file I/O operations
// Hint: You'll need classes from java.io or java.nio.file packages
// You'll also need Scanner for user input

import java.util.Scanner;
import java.io.FileReader;

public class ContactReader {
    public static void main(String[] args) {
        // Step 2: Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Step 3: Prompt the user to enter the file name containing contacts
        // Example: "Enter the name of the contacts file:"
        System.out.println("Enter the name of the contacts file:");

        // Step 4: Read the file name entered by the user
        String fileName = scanner.nextLine();

        try {
            // Step 5: Create a FileReader or similar object to read the file
            // Hint: You can use FileReader, BufferedReader, or Files class
            Scanner fileScanner = new Scanner(new FileReader(fileName));
            
            // Step 6: Read the file line by line
            // Hint: Use a loop to process each line
            while(fileScanner.hasNext()) {
            
                // Step 7: Parse each line to extract name and phone number
                // Hint: Use String methods like split() to separate by colon
                String fileLine = fileScanner.nextLine();

                String[] contactDetails = fileLine.split(",");

                // Step 8: Display the contact information in a formatted way
                // Example: "Contact: John Doe | Phone: +1-555-123-4567"
                for(String contactDetails : contacts) {
                    System.out.println("Contact: " + contactDetails[0] + " | Phone: " + contactDetails[1]);
                }

            }
            
            // Step 9: Close the file reader when done
            fileScanner.close();

        } catch (Exception e) {
            // Step 10: Handle exceptions appropriately
            // Display a user-friendly error message
            System.out.println(e.getMessage + ": Error reading the file " + fileName);
            
        }
        
        // Optional Bonus:
        // Step 11: Add a feature to count and display the total number of contacts read
    }
}
