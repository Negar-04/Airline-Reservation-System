import java.util.Objects;
import java.util.Scanner;

public class Passengermenu {
    Scanner input = new Scanner(System.in);
    public void printMenu() {
        System.out.println("\t\t\t\t<<PASSENGER MENU OPTIONS>>\t\t");
        System.out.println("<1> Change password");
        System.out.println("<2> Search flight tickets");
        System.out.println("<3> Booking ticket");
        System.out.println("<4> Ticket cancellation");
        System.out.println("<5> Booked tickets");
        System.out.println("<6> Add charge");
        System.out.println("<0> Sign out");
    }
    public void passengersMenu(String username,int j,Database database) {
        printMenu();
        String command = input.next();

        while (!Objects.equals(command, "0")) {
            switch (command) {
                case "1" -> changePassword(j,database);
                case "2" -> search(database);
                case "3" -> bookTicket(j,database);///j
                case "4" -> cancellation(j,database);////pass j
                case "5" -> bookedtickets(username,database); ////pass j
                case "6" -> charge(j,database);////pass j
                default -> System.out.println("Not valid !\nPlease try again.");
            }
            printMenu();
            command = input.next();
        }
    }
    public void changePassword(int j,Database database) {
        System.out.println("Please enter your previous password: ");
        String previousPass = input.next();
        for (int k = 0; k < j; k++) {
            if (Objects.equals(previousPass, database.passengers.information[k].getPassword())) {
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
                database.passengers.changePassword(k,newPassword1);
                System.out.println("This action was done successfully.");
                break;
            }
        }
    }
    public void charge(int j,Database database) {
        String price;
        boolean bool = true;
        System.out.println("Your charge is >> " + database.passengers.information[j].getCredit());
        while (bool) {
            System.out.println("Please enter the amount to increase your charge :");
            price = input.next();
            if (database.isNumeric(price) && Integer.parseInt(price)>=0) {
                database.passengers.addCharge(j, price);
                System.out.println("Your charge is >> " + database.passengers.information[j].getCredit());
                bool = false;
            }
            else
                System.out.println("Not valid !");
        }
    }
    public void bookTicket(int j,Database database) {
        System.out.println("Please enter the flightId that you want to book:");
        String flightId = input.next();
        database.tickets.bookTicket(flightId,j,database);
    }
    public void search(Database database) {
        System.out.println("Please enter your origin:    <enter the first letter in upper case>");
        String origin = input.next();
        System.out.println("Please enter your destination:    <enter the first letter in upper case>");
        String destination = input.next();
        int a = 0;
        System.out.println("\n\t | FlightId | Origin | Destination | Date     |  Time  | Price    | Seats |");
        for (int k = 0; k < database.flights.info.size(); k++) {
            if (Objects.equals(origin, database.flights.info.get(k).getOrigin()) && Objects.equals(destination, database.flights.info.get(k).getDestination())) {
                System.out.println("\n\t----------------------------------------------------------------------------");
                System.out.println("\t | " + database.flights.info.get(k).getFlightId() + "\t| " + database.flights.info.get(k).getOrigin() + "\t | " + database.flights.info.get(k).getDestination() + "\t  | " + database.flights.info.get(k).getDate() + "\t| " + database.flights.info.get(k).getTime() + " | " + database.flights.info.get(k).getPrice() + " | " + database.flights.info.get(k).getSeat() + " | ");
                a = 1;
            }
        }
        System.out.println();
        if (a == 0)
            System.out.println("There isn't any flight with these specifications.");
    }
    public void bookedtickets(String username,Database database){
        System.out.println("\t | TicketId | FlightId | Origin | Destination | Date     |  Time  | Price    | Seats |");
        for (int i=0;i<database.tickets.tickets.size();i++){
            if(Objects.equals(database.tickets.tickets.get(i).getPassengers().getUsername(), username)){
                System.out.println("\n\t----------------------------------------------------------------------------");
                System.out.println( " \t\t"+database.tickets.tickets.get(i).getTicketId()+"\t\t\t|"+database.tickets.tickets.get(i).getFlight().getFlightId()+"\t\t|"+database.tickets.tickets.get(i).getFlight().getOrigin()+"\t\t|   "+database.tickets.tickets.get(i).getFlight().getDestination()+"\t\t|"+database.tickets.tickets.get(i).getFlight().getDate()+"\t\t|"+database.tickets.tickets.get(i).getFlight().getTime()+"\t\t|"+database.tickets.tickets.get(i).getFlight().getPrice()+"\t\t|"+database.tickets.tickets.get(i).getFlight().getSeat()+"  |");
            }
        }
    }
    public void cancellation(int j,Database database){
        System.out.println("Please enter the ticketId to cancel your reservation :");
        String ticketId = input.next();
        database.tickets.cancellation(ticketId,j,database);
    }
}
