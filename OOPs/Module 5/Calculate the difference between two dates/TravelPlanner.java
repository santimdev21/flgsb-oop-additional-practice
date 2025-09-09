import java.time.LocalDate; // permite usar objetos tipo LocalDate para manejar fechas
import java.time.format.DateTimeFormatter; // permite usar objetos Formatter para formatear string a DateTime objects
import java.time.format.DateTimeParseException; // excepcion lanzada debido a un error convirtiendo un String a DateTime
import java.time.Period; // permite saber el intervalo de timpo entre dos objetos date
import java.time.temporal.ChronoUnit; // Clase enum que contiene constantes para dias de la semana entre otras
import java.util.Scanner; // permite la entrada del usuario

/**
 * TravelPlanner - A utility to help travelers plan their trips
 * This class provides functionality to:
 * 1. Calculate the duration of a trip
 * 2. Validate travel dates
 * 3. Calculate check-in and check-out dates
 * 4. Check if a trip overlaps with holidays
 */
public class TravelPlanner {
    
    // Step 1: Declare a DateTimeFormatter for the standard date format "dd/MM/yyyy"
    // Hint: Use DateTimeFormatter.ofPattern()

    static String pattern = "dd/MM/yyyy";
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
    
    /**
     * Calculates the duration of a trip in days
     * @param departureDate The date of departure
     * @param returnDate The date of return
     * @return The number of days between departure and return
     */
    public static long calculateTripDuration(LocalDate departureDate, LocalDate returnDate) {
        // Step 2: Calculate and return the number of days between departure and return dates
        // Hint: Use ChronoUnit.DAYS.between()
        long tripDuration = ChronoUnit.DAYS.between(departureDate, returnDate);

        return tripDuration; // Replace with actual calculation
    }
    
    /**
     * Validates that the provided dates make logical sense for a trip
     * @param departureDate The date of departure
     * @param returnDate The date of return
     * @return true if dates are valid, false otherwise
     */
    public static boolean validateTravelDates(LocalDate departureDate, LocalDate returnDate) {
        // Step 3: Implement validation logic:
        // - Departure date should not be in the past
        // - Return date should be after departure date
        // - Trip should not be longer than 90 days
        // Hint: Use LocalDate.now() for current date and various comparison methods
        if(departureDate.isBefore(LocalDate.now()) || returnDate.isBefore(departureDate)) {
            return false;
        }

        if(calculateTripDuration(departureDate, returnDate) > 90) {
            return false;
        } 
        
        return true; // Replace with actual validation
    }
    
    /**
     * Calculates hotel check-in and check-out dates based on travel dates
     * @param departureDate The date of departure
     * @param returnDate The date of return
     * @return A string containing the check-in and check-out dates
     */
    public static String calculateHotelDates(LocalDate departureDate, LocalDate returnDate) {
        // Step 4: Calculate hotel dates:
        // - Check-in is usually the same day as departure
        // - Check-out is usually the same day as return
        // Hint: Format the dates using the formatter declared in Step 1
        String dates = "Cheack-in date: " + departureDate.format(formatter) + "\nCheack-out date: " + returnDate.format(formatter);
        
        return dates; // Replace with actual calculation
    }
    
    /**
     * Checks if a trip overlaps with a specific holiday
     * @param departureDate The date of departure
     * @param returnDate The date of return
     * @param holidayDate The date of the holiday
     * @return true if the trip overlaps with the holiday, false otherwise
     */
    public static boolean tripOverlapsHoliday(LocalDate departureDate, LocalDate returnDate, LocalDate holidayDate) {
        // Step 5: Check if the holiday date falls between departure and return dates
        // Hint: Use isAfter() and isBefore() methods or similar
        if((holidayDate.isAfter(departureDate) && holidayDate.isBefore(returnDate)) && (!holidayDate.isEqual(departureDate)  !holidayDate.isEqual(returnDate)) ) {
            return true;
        }
        
        return false; // Replace with actual check
    }
    
    /**
     * Main method to run the TravelPlanner application
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Step 6: Implement a menu-driven interface allowing the user to:
        // - Enter departure and return dates
        // - Calculate trip duration
        // - Validate travel dates
        // - Calculate hotel check-in and check-out dates
        // - Check if trip overlaps with holidays
        
        // Step 7: Use try-catch blocks to handle invalid date inputs
        // Hint: Catch DateTimeParseException for invalid date formats
        
        // Step 8: Display appropriate messages to the user based on the operations performed
        
        LocalDate departureDate = LocalDate.now();
        LocalDate returnDate = LocalDate.now();

        boolean datesCreated = false;

        System.out.println("Welcome to TravelPlanner application!");
        System.out.println("What do you want to do?");

        while(true) {

            System.out.println("1. New departure and return dates" + "\n2. Calculate trip duration" + "\n3. Validate travel dates" +
                                "\n4. Calculate hotel check-in and check-out dates" + "\n5. Check if trip overlaps with holidays" +
                                "\n6. Exit the program");

            String userOption = scanner.nextLine();

            if(userOption.equals("1")) {
                System.out.println("Enter the departure date with pattern: " + pattern);
                String departureDateStr = scanner.nextLine();

                System.out.println("Enter the return date with pattern: " + pattern);
                String returnDateStr = scanner.nextLine();

                try {
                    departureDate = LocalDate.parse(departureDateStr, formatter);
                    returnDate = LocalDate.parse(returnDateStr, formatter);
                } catch(DateTimeParseException dfpe) {
                    System.out.println("Error: enter a valid date");
                    continue;
                }

                System.out.println("Dates created succesfully!");
                datesCreated = true;

            } else if(datesCreated) { 
                if(userOption.equals("2")) {
                System.out.println("Trip duration is " + calculateTripDuration(departureDate, returnDate) + " days(s).");
                } else if(userOption.equals("3")) {
                    if(validateTravelDates(departureDate, returnDate)) {
                        System.out.println("Dates are valid");
                    } else {
                        System.out.println("Dates are invalid");
                    }
                } else if(userOption.equals("4")) {
                    System.out.println(calculateHotelDates(departureDate, returnDate));
                } else if(userOption.equals("5")) {
                    try {
                        System.out.println("Enter the holiday date with pattern: " + pattern);
                        String holidayDateStr = scanner.nextLine();

                        LocalDate holidayDate = LocalDate.parse(holidayDateStr, formatter);

                        if(tripOverlapsHoliday(departureDate, returnDate, holidayDate)) {
                            System.out.println("Trip overlaps holiday");
                        } else {
                            System.out.println("Trip does not overlap holiday");
                        }
                    } catch(DateTimeParseException dfpe) {
                        System.out.println("Enter a valid date");
                    }
                } else if(userOption.equals("6")) {
                    System.out.println("Closing program...");
                    break;
                } else {
                    System.out.println("Enter a valid option");
                }
            } else {
                System.out.println("To do other actions first you need to enter travel dates");
            }
        }
        
        scanner.close();
    }
}