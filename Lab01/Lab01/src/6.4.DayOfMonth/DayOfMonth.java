import java.util.Scanner;
public class DayOfMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int month, year;
        boolean validInput = false;

        // Loop until valid input is provided
        do {
            System.out.print("Enter the month (1-12): ");
            month = scanner.nextInt();
            System.out.print("Enter the year: ");
            year = scanner.nextInt();

            // Check if the month and year are valid
            if (month < 1 || month > 12 || year < 1) {
                System.out.println("Invalid month or year. Please enter again.");
                continue;
            } else {
                validInput = true;
            }

//            System.out.print("Enter the year: ");
//            year = scanner.nextInt();
        } while (!validInput);

        // Determine the number of days in the entered month
        int daysInMonth;
        switch (month) {
            case 2: // February
                if (isLeapYear(year)) {
                    daysInMonth = 29;
                } else {
                    daysInMonth = 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11: // April, June, September, November
                daysInMonth = 30;
                break;
            default: // January, March, May, July, August, October, December
                daysInMonth = 31;
                break;
        }

        System.out.println("Number of days in the entered month: " + daysInMonth);

        scanner.close();
    }

    // Method to check if a year is a leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
