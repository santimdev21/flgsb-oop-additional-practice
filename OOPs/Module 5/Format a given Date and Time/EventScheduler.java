// EventScheduler.java
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.format.DateTimeParseException;

public class EventScheduler {
    private List<Event> events;
    private Scanner scanner;
    
    public EventScheduler() {
        // Step 7: Initialize the events list and scanner
        this.events = new ArrayList<Event>();
        this.scanner = new Scanner(System.in);
    }
    
    public void run() {
        boolean running = true;
        while (running) {
            // Step 8: Display menu options
            System.out.println("\n=== Event Scheduler ===");
            System.out.println("1. Add Event");
            System.out.println("2. Display All Events");
            System.out.println("3. Show Time Until Event");
            System.out.println("4. Convert Event Time to Different Timezone");
            System.out.println("5. Find Upcoming Events");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = Integer.parseInt(scanner.nextLine());
            
            // Step 9: Implement menu choices using switch-case
            switch (choice) {
                case 1:
                    // Call method to add event
                    break;
                case 2:
                    // Call method to display all events
                    break;
                case 3:
                    // Call method to show time until event
                    break;
                case 4:
                    // Call method to convert event time
                    break;
                case 5:
                    // Call method to find upcoming events
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting the Event Scheduler. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private void addEvent() {
        // Step 10: Implement method to get event details from user and create a new Event
        // Hint: Get name, date, time, duration, and timezone from user
        // Parse the date and time strings into LocalDateTime
        // Get a ZoneId from the timezone string
        // Create a ZonedDateTime from LocalDateTime and ZoneId
        // Create a Duration object from hours and minutes
        // Create a new Event object and add it to the events list
        System.out.println("Enter the event name");
        String name = scanner.nextLine();

        System.out.println("Enter the event date");
        String date = scanner.nextLine();
    }
    
    private void displayAllEvents() {
        // Step 11: Implement method to display all events
        // Hint: Get format pattern from user
        // Loop through events list and display each event with the specified format
    }
    
    private void showTimeUntilEvent() {
        // Step 12: Implement method to calculate and display time until a specific event
        // Hint: Show list of events with numbers
        // Get event selection from user
        // Calculate and display time until the selected event
    }
    
    private void convertEventTime() {
        // Step 13: Implement method to convert event time to a different timezone
        // Hint: Show list of events with numbers
        // Get event selection from user
        // Get target timezone from user
        // Convert and display event time in the target timezone
    }
    
    private void findUpcomingEvents() {
        // Step 14: Implement method to find events within a specific number of days
        // Hint: Get number of days from user
        // Loop through events and display those within the specified days
    }
    
    public static void main(String[] args) {
        // Step 15: Create an EventScheduler object and call its run method
        EventScheduler scheduler = new EventScheduler();
        scheduler.run();
    }
}
