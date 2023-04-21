import java.util.Objects;
import java.util.Scanner;

public class PassengerMenu {
    Scanner input = new Scanner(System.in);

    /**
     * print the primary menu of passengers
     */
    public void printMenu() {
        System.out.println("\t\t\t\t\u001b[33m<<PASSENGER MENU OPTIONS>>\u001b[0m\t\t");
        System.out.println("<1> Change password");
        System.out.println("<2> Search flight tickets");
        System.out.println("<3> Booking ticket");
        System.out.println("<4> Ticket cancellation");
        System.out.println("<5> Booked tickets");
        System.out.println("<6> Add charge");
        System.out.println("<0> Sign out");
    }

    /**
     * get the command from passenger to perform his / her required activities
     *
     * @param username of the user who signed in
     * @param j        the related index of each user in the array of passengers
     * @param database has the requisite information
     */
    public void passengersMenu(String username, int j, Database database) {

        printMenu();
        String command = input.next();

        while (!Objects.equals(command, "0")) {
            switch (command) {
                case "1" -> changePassword(j, database);
                case "2" -> search(database);
                case "3" -> bookTicket(j, database);
                case "4" -> cancellation(j, database);
                case "5" -> bookedTickets(username, database);
                case "6" -> charge(j, database);
                default -> System.out.println("\u001b[31mNot valid !\u001b[0m\nPlease try again.");
            }
            printMenu();
            command = input.next();
        }
    }

    /**
     * First , get previous password from user and then ask the user to enter the new password twice
     *
     * @param j        the related index of each user in the array of passengers
     * @param database has the requisite information
     */

    public void changePassword(int j, Database database) {

        int count = 0;
        System.out.println("Please enter your previous password: ");
        String previousPass = input.next();

        for (int k = 0; k <= j; k++) {
            if (Objects.equals(previousPass, database.passengers.information[k].getPassword())) {
                count = 1;
                System.out.println("Please enter the new password:");
                String newPassword1 = input.next();
                System.out.println("Please enter the password again:");
                String newPassword2 = input.next();

                while (true) {
                    if (!Objects.equals(newPassword1, newPassword2)) {
                        System.out.println("<<Passwords aren't the same.>>\n\nPlease enter new password:");
                        newPassword1 = input.next();
                        System.out.println("Please enter the password again:");
                        newPassword2 = input.next();
                    } else
                        break;
                }

                database.passengers.changePassword(k, newPassword1);
                System.out.println("This action was done successfully.\n");
                break;
            }
        }
        if (count == 0)
            System.out.println("Your previous password is wrong.\n");
    }

    /**
     * increase the charge of the passengers' account that they have enough charge to book ticket
     *
     * @param j        the related index of each user in the array of passengers
     * @param database has the requisite information
     */

    public void charge(int j, Database database) {
        String price;
        boolean bool = true;
        System.out.println("Your charge is >> " + database.passengers.information[j].getCredit());

        while (bool) {
            System.out.println("Please enter the amount to increase your charge :");
            price = input.next();
            if (database.isNumeric(price) && Integer.parseInt(price) >= 0) {
                database.passengers.addCharge(j, price);
                System.out.println("Your charge is >> " + database.passengers.information[j].getCredit());
                bool = false;
            } else
                System.out.println("\u001b[31mNot valid !\u001b[0m");
        }
    }

    /**
     * reserve flight and book ticket based on flightId
     *
     * @param j        the related index of each user in the array of passengers
     * @param database has the requisite information
     */

    public void bookTicket(int j, Database database) {

        System.out.println("Please enter the flightId that you want to book:");
        String flightId = input.next();

        int temp = database.tickets.bookTicket(flightId, j, database);

        switch (temp) {
            case 0 -> System.out.println("This Id wasn't found.");
            case -1 -> System.out.println("This flight has no seat.");
            case -2 -> System.out.println("You don't have enough charge.");
            default -> System.out.println("Your ticketId is >> " + database.tickets.ticketArray[temp - 1] + "\n");
        }
    }

    /**
     * search flights based on two filters : origin and destination
     *
     * @param database has the requisite information
     */

    public void search(Database database) {
        int a = 0;
        System.out.println("Please enter your origin:    <enter the first letter in upper case>");
        String origin = input.next();
        System.out.println("Please enter your destination:    <enter the first letter in upper case>");
        String destination = input.next();

        System.out.println("\u001b[35m|\u001b[0m FlightId \u001b[35m|\u001b[0m    Origin     \u001b[35m|\u001b[0m  Destination  \u001b[35m|\u001b[0m    Date    \u001b[35m|\u001b[0m Time  \u001b[35m|\u001b[0m    Price   \u001b[35m|\u001b[0m  Seats \u001b[35m|\u001b[0m");

        for (int k = 0; k < database.flights.info.size(); k++) {
            if (Objects.equals(origin, database.flights.info.get(k).getOrigin()) && Objects.equals(destination, database.flights.info.get(k).getDestination())) {
                System.out.print("\u001b[35m---------------------------------------------------------------------------------------\u001b[0m\n");
                System.out.printf("\u001b[35m|\u001b[0m%-10s\u001b[35m|\u001b[0m%-15s\u001b[35m|\u001b[0m%-15s\u001b[35m|\u001b[0m%-12s\u001b[35m|\u001b[0m%-7s\u001b[35m|\u001b[0m%-12s\u001b[35m|\u001b[0m%-8s\u001b[35m|\u001b[0m %n", database.flights.info.get(k).getFlightId(), database.flights.info.get(k).getOrigin(), database.flights.info.get(k).getDestination(), database.flights.info.get(k).getDate(), database.flights.info.get(k).getTime(), database.flights.info.get(k).getPrice(), database.flights.info.get(k).getSeat());
                a = 1;
            }
        }
        System.out.println();

        if (a == 0)
            System.out.println("There isn't any flights with these specifications.\n");
    }

    /**
     * print and show all the booked tickets of each passenger
     *
     * @param username of the user who signed in
     * @param database has the requisite information
     */

    public void bookedTickets(String username, Database database) {
        int count = 0;
        System.out.println("\u001b[35m|\u001b[0m TicketId \u001b[35m|\u001b[0m FlightId \u001b[35m|\u001b[0m    Origin     \u001b[35m|\u001b[0m  Destination  \u001b[35m|\u001b[0m    Date    \u001b[35m|\u001b[0m Time  \u001b[35m|\u001b[0m    Price   \u001b[35m|\u001b[0m  Seats \u001b[35m|\u001b[0m");

        for (int i = 0; i < database.tickets.tickets.size(); i++) {
            if (Objects.equals(database.tickets.tickets.get(i).getPassengers().getUsername(), username)) {
                System.out.print("\u001b[35m--------------------------------------------------------------------------------------------------\u001b[0m\n");
                System.out.printf("\u001b[35m|\u001b[0m%-10s\u001b[35m|\u001b[0m%-10s\u001b[35m|\u001b[0m%-15s\u001b[35m|\u001b[0m%-15s\u001b[35m|\u001b[0m%-12s\u001b[35m|\u001b[0m%-7s\u001b[35m|\u001b[0m%-12s\u001b[35m|\u001b[0m%-8s\u001b[35m|\u001b[0m %n", database.tickets.tickets.get(i).getTicketId(), database.tickets.tickets.get(i).getFlight().getFlightId(), database.tickets.tickets.get(i).getFlight().getOrigin(), database.tickets.tickets.get(i).getFlight().getDestination(), database.tickets.tickets.get(i).getFlight().getDate(), database.tickets.tickets.get(i).getFlight().getTime(), database.tickets.tickets.get(i).getFlight().getPrice(), database.tickets.tickets.get(i).getFlight().getSeat());
                count = 1;
            }
        }
        System.out.println();

        if (count == 0)
            System.out.println("You don't reserve any flights.\n");
    }

    /**
     * cancel and remove the purchased ticket based on ticketId
     *
     * @param j        the related index of each user in the array of passengers
     * @param database has the requisite information
     */

    public void cancellation(int j, Database database) {

        System.out.println("Please enter the ticketId to cancel your reservation :");
        String ticketId = input.next();

        int temp = database.tickets.cancellation(ticketId, j, database);

        if (temp == 1)
            System.out.println("This action was done successfully.\n");
        if (temp == 0)
            System.out.println("This ticketId is invalid.");
    }
}
