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
                    addEvent();
                    break;
                case 2:
                    // Call method to display all events
                    displayAllEvents();
                    break;
                case 3:
                    // Call method to show time until event
                    showTimeUntilEvent();
                    break;
                case 4:
                    // Call method to convert event time
                    convertEventTime();
                    break;
                case 5:
                    // Call method to find upcoming events
                    findUpcomingEvents();
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
        String pattern = "dd/MM/yyyy hh:mm:ss";
        
        try {
            System.out.println("Enter the event name");
            String name = scanner.nextLine();

            System.out.println("Enter the event date and time in format: " + pattern);
            String dateTimeStr = scanner.nextLine();

            System.out.println("Enter the timezone");
            String timezone = scanner.nextLine();

            System.out.println("Enter the event duration in hours and minutes");
            System.out.println("Hours: ");
            long hours = Long.parseLong(scanner.nextLine());

            System.out.println("Minutes: ");
            long minutes = Long.parseLong(scanner.nextLine());


            LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, pattern);

            ZoneId zone = ZoneId.of(timezone);

            ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, zone);

            Duration duration = Duration.ofHours(hours);
            duration.plusMinutes(minutes);

            Event event = new Event(name, zonedDateTime, duration);
            this.events.add(event);

        } catch (DateTimeParseException dtpe) {
            System.out.println("Error: enter a valid date and time");
        } catch (NumberFormatException nfe) {
            System.out.println("Error: enter a valid duration");
        } catch (DateTimeException dte) {
            System.out.println("Error: enter a valid timezone");
        } catch (ArithmeticException ae) {
            System.out.println(at.getMessage());
        } 
        
        
    }
    
    private void displayAllEvents() {
        // Step 11: Implement method to display all events
        // Hint: Get format pattern from user
        // Loop through events list and display each event with the specified format
        System.out.println("Enter the format in which you want to display the events:");
        String formatter = scanner.nextLine();

        for(Event event : events) {
            System.out.println(event);
        }
    }
    
    private void showTimeUntilEvent() {
        // Step 12: Implement method to calculate and display time until a specific event
        // Hint: Show list of events with numbers
        // Get event selection from user
        // Calculate and display time until the selected event
        try {
            for(int i = 0; i < events.length; i++) {
                    System.out.println(i+1 + "- " + events.get(i));
                }

            System.out.println("Enter the index of the event to display:");
            int index = Integer.parseInt(scanner.nextLine());

            Duration duration = events.get(index).timeRemaining();
            System.out.println("Time until event: " + duration.toDays() + " day(s) " + duration.toHours + " hour(s) " + duration.toMinutes() + " minute(s)");
        } catch(IndexOutOfBoundsException iobe) {
            System.out.println("Error: index not found");
        } catch (NumberFormatException nfe) {
            System.out.println("Error: invalid index");
        }
    }
    
    private void convertEventTime() {
        // Step 13: Implement method to convert event time to a different timezone
        // Hint: Show list of events with numbers
        // Get event selection from user
        // Get target timezone from user
        // Convert and display event time in the target timezone
        try {
            for(int i = 0; i < events.length; i++) {
                    System.out.println(i+1 + "- " + events.get(i));
                }

            System.out.println("Enter the index of the event to convert timezone:");
            int index = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter the new timezone");
            String timezoneId = scanner.nextLine();

            events.get(index).changeTimeZone(timezoneId);
        } catch(IndexOutOfBoundsException iobe) {
            System.out.println("Error: index not found");
        } catch (NumberFormatException nfe) {
            System.out.println("Error: invalid index");
        }
    }
    
    private void findUpcomingEvents() {
        // Step 14: Implement method to find events within a specific number of days
        // Hint: Get number of days from user
        // Loop through events and display those within the specified days
        try {
            System.out.println("Enter the number of days target:");
            int days = Long.parseLong(scanner.nextLine());

            for(Event event : events) {
                if(event.timeRemaining().toDays() <= days) {
                    System.out.println(events.get(i));
                }
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Error: invalid index");
        }
    }
    
    public static void main(String[] args) {
        // Step 15: Create an EventScheduler object and call its run method
        EventScheduler scheduler = new EventScheduler();
        scheduler.run();
    }
}
