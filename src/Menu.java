import java.util.Objects;
import java.util.Scanner;

public class Menu {
    Scanner input = new Scanner(System.in);
    AdminMenu adminmenu = new AdminMenu();
    PassengerMenu passengermenu = new PassengerMenu();
    int j = 0;

    /**
     * print and show the start menu
     * press (1) to sign in
     * press (2) to sign up
     * press (3) to exit from the program
     *
     * @param database has the requisite information
     */
    public void startMenu(Database database) {

        System.out.println("\n\033[94m----------------\u001b[0mWELCOME TO AIRLINE RESERVATION SYSTEM\033[94m----------------\u001b[0m\n");
        System.out.println("\t\t\t\t\t\t\u001b[33m<<MENU OPTIONS>>\u001b[0m\t\t\t\n");
        System.out.println("Please choose one of these :");
        System.out.println("<1> Sign in");
        System.out.println("<2> Sign up");
        System.out.println("<3> Exit");
        String command = input.next();

        while (!Objects.equals(command, "3")) {
            switch (command) {
                case "1" -> signIn(database);
                case "2" -> signUp(database);
                default -> System.out.println("\u001b[31mNot valid !\u001b[0m\nPlease try again.");
            }

            System.out.println("\t\t\t\t\t\t <<MENU OPTIONS>>\t\t\t\n");
            System.out.println("Please choose one of these :");
            System.out.println("<1> Sign in");
            System.out.println("<2> Sign up");
            System.out.println("<3> Exit");
            command = input.next();
        }
    }

    /**
     * get the username and password ---> create new account for users
     * don't accept existed username
     *
     * @param database has the requisite information
     */
    public void signUp(Database database) {
        int a = 1;
        System.out.println("Please enter username:");
        String username = input.next();

        while (a == 1) {
            for (int k = 0; k < j; k++) {
                if (Objects.equals(username, database.passengers.information[k].getUsername())) {
                    System.out.println("This username exists !\nPlease enter another username :");
                    username = input.next();
                    k = -1;
                }
            }
            a = 0;
        }
        System.out.println("Please enter password:");
        String password = input.next();
        database.passengers.information[j++] = new Passenger(username, password, "0");
    }

    int temp = 0;

    /**
     * get username and password from admin and passengers to log into their accounts
     *
     * @param database has the requisite information
     */

    public void signIn(Database database) {
        if (temp == 0)
            database.flights.defaultInfo();
        temp = 1;

        System.out.println("Please enter your username:");
        String username = input.next();
        System.out.println("Please enter your password:");
        String password = input.next();
        int count = 0;

        if (Objects.equals(username, database.admins.admins.get(0).getUsername()) && Objects.equals(password, database.admins.admins.get(0).getPassword())) {
            adminmenu.adminMenu(database);
            count = 7;
        }

        for (int k = 0; k < j; k++) {
            if (Objects.equals(database.passengers.information[k].getUsername(), username) && Objects.equals(database.passengers.information[k].getPassword(), password)) {
                passengermenu.passengersMenu(username, k, database);
                count = 1;
            }
        }

        if (count == 0)
            System.out.println("This account hasn't been created yet !\nPlease sign up first.");
    }
}
