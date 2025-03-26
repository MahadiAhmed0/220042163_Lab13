import java.util.Scanner;

public class MenuService {
    private Scanner scanner;

    public MenuService() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMainMenu() {
        System.out.println("\n\n\t\t(a) Press 0 to Exit.");
        System.out.println("\t\t(b) Press 1 to Login as admin.");
        System.out.println("\t\t(c) Press 2 to Register as admin.");
        System.out.println("\t\t(d) Press 3 to Login as Passenger.");
        System.out.println("\t\t(e) Press 4 to Register as Passenger.");
        System.out.println("\t\t(f) Press 5 to Display the User Manual.");
        System.out.print("\t\tEnter the desired option:    ");
    }

    public void displayAdminMenu(String username) {
        System.out.printf("\n\n%-60s+++++++++ Admin Menu +++++++++%50sLogged in as \"%s\"\n", "", "", username);
        System.out.printf("%-30s (a) Enter 1 to add new Passenger....\n", "");
        System.out.printf("%-30s (b) Enter 2 to search a Passenger....\n", "");
        System.out.printf("%-30s (c) Enter 3 to update the Data of the Passenger....\n", "");
        System.out.printf("%-30s (d) Enter 4 to delete a Passenger....\n", "");
        System.out.printf("%-30s (e) Enter 5 to Display all Passengers....\n", "");
        System.out.printf("%-30s (f) Enter 6 to Display all flights registered by a Passenger...\n", "");
        System.out.printf("%-30s (g) Enter 7 to Display all registered Passengers in a Flight....\n", "");
        System.out.printf("%-30s (h) Enter 8 to Delete a Flight....\n", "");
        System.out.printf("%-30s (i) Enter 0 to Go back to the Main Menu/Logout....\n", "");
    }

    public void displayPassengerMenu(String username) {
        System.out.printf("\n\n%-60s+++++++++ Passenger Menu +++++++++%50sLogged in as \"%s\"\n", "", "", username);
        System.out.printf("%-40s (a) Enter 1 to Book a flight....\n", "");
        System.out.printf("%-40s (b) Enter 2 to update your Data....\n", "");
        System.out.printf("%-40s (c) Enter 3 to delete your account....\n", "");
        System.out.printf("%-40s (d) Enter 4 to Display Flight Schedule....\n", "");
        System.out.printf("%-40s (e) Enter 5 to Cancel a Flight....\n", "");
        System.out.printf("%-40s (f) Enter 6 to Display all your registered flights....\n", "");
        System.out.printf("%-40s (g) Enter 0 to Go back to the Main Menu/Logout....\n", "");
    }

    public int getValidatedInput(int min, int max) {
        int input = scanner.nextInt();
        while (input < min || input > max) {
            System.out.printf("ERROR!! Please enter value between %d - %d. Enter the value again:\t", min, max);
            input = scanner.nextInt();
        }
        return input;
    }
}