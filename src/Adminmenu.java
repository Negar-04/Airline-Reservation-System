import java.util.Objects;
import java.util.Scanner;

public class Adminmenu {
    Scanner input = new Scanner(System.in);
    public void printAdminMenu(){
        System.out.println("\t\t\t\t\t\t<<Admin Menu OPTIONS>>\t\t");
        System.out.println("<1> Add");
        System.out.println("<2> update");
        System.out.println("<3> Remove");
        System.out.println("<4> Flight Schedules");
        System.out.println("<0> Sign out");
    }
    public void adminMenu(Database database){

        printAdminMenu();
        String command = input.next();

        while (!Objects.equals(command, "0")) {

            switch (command) {
                case "1" -> addFlight(database);
                case "2" -> update(database);
                case "3" -> remove(database);
                case "4" -> showChart(database);
                default -> System.out.println("Not valid !\nPlease try again.");
            }
            printAdminMenu();
            command = input.next();
            }
        }
        public void addFlight(Database database) {
            String origin = null;
            System.out.println("please enter flightId :");
            String flightId = input.next();
            for (int i = 0; i < database.flights.info.size(); i++) {
                if (Objects.equals(flightId, database.flights.info.get(i).getFlightId())) {
                    System.out.println("This Id exists.");
                    System.out.println("Please enter flightId :");
                    flightId = input.next();
                    i = -1;
                }
            }
            boolean test2 = true;
            while (test2) {
                System.out.println("please enter origin :  <enter the first letter in upper case>");
                origin = input.next();
                if (!database.isNumeric(origin))
                    System.out.println("Not valid !");
                else
                    break;
            }
            boolean bool2 = true;
            String destination = null;

            while (bool2) {
                System.out.println("please enter destination :   <enter the first letter in upper case>");
                destination = input.next();
                if (!Objects.equals(destination, origin ) && database.isNumeric(destination)) {
                    bool2 = false;
                } else
                    System.out.println("Not valid !");
            }
            System.out.println("please enter date :");
            String date = input.next();
            System.out.println("please enter time :");
            String time = input.next();
            boolean bool1 = true;
            String price = null;
            while (bool1) {
                System.out.println("please enter price :");
                price = input.next();
                if (database.isNumeric(price) && Integer.parseInt(price) > 0)
                    bool1 = false;
                else
                    System.out.println("Not valid !");
            }
            boolean test = true;
            String seat = null;
            while (test) {
                System.out.println("please enter seats :");
                seat = input.next();
                if (database.isNumeric(seat) && Integer.parseInt(seat) > 0)
                    test = false;
                else
                    System.out.println("Not valid !");
            }
            database.flights.addFlight(flightId, origin, destination, date, time, price, seat);
            System.out.println("This action was done successfully.\n");
        }
        public void remove(Database database){
        int temp=0;
        int count=0;
        System.out.println("Please enter the flightId that you want to remove :");
        String removeId = input.next();
        for (int i = 0; i < database.tickets.tickets.size(); i++) {
            if (Objects.equals(database.tickets.tickets.get(i).getFlight().getFlightId(), removeId)) {
                System.out.println("You can't remove this flight ; it has already booked.\n");
                temp=1;
                break;
            }
        }
        if (temp==0)
          count = database.flights.remove(removeId);
        if (count==0 && temp==0)///////////check
            System.out.println("This Id wasn't found !\n");
        if (count!=0)
            System.out.println("This action was done successfully.\n");
        }
        public void update(Database database){
            System.out.println("Please enter the flightId that you want to update :");
            String updateId = input.next();
            int c=0;
            for (int i=0;i<database.tickets.tickets.size();i++){
                if (Objects.equals(database.tickets.tickets.get(i).getFlight().getFlightId(), updateId)){
                    System.out.println("You can't update this flight ; it has already booked.\n");
                    c=1;
                    break;
                }
            }
            int count=0,temp=0;

            if (c==0) {
                for (int k = 0; k < database.flights.info.size(); k++) {
                    if (Objects.equals(updateId, database.flights.info.get(k).getFlightId())) {
                        System.out.println("\nWhich branch of flight do you want to update ?\n");
                        System.out.println("1-FlightId\t 2-origin\t3-Destination\t 4-Date\t  5-Time\t 6-Price\t7-seats\n");
                        System.out.println("Please enter the number :");
                        String number = input.next();
                        switch (number) {
                            case "1" -> {
                                System.out.println("Please enter new Id :");
                                String newId = input.next();
                                for (int i = 0; i < database.flights.info.size(); i++) {
                                    if (Objects.equals(newId, database.flights.info.get(i).getFlightId())) {
                                        System.out.println("This Id exists.");
                                        System.out.println("Please enter new Id :");
                                        newId = input.next();
                                        i = -1;
                                    }
                                }
                                database.flights.update(k, newId, number);
                            }
                            case "2" -> {
                                boolean bool = true;
                                String newOrigin = null;
                                while (bool) {
                                    System.out.println("Please enter new origin :  <enter the first letter in upper case>");
                                    newOrigin = input.next();
                                    if (!Objects.equals(newOrigin, database.flights.info.get(k).getOrigin()) && database.isNumeric(newOrigin))
                                        bool = false;
                                    else
                                        System.out.println("Not valid !");
                                }
                                database.flights.update(k, newOrigin, number);
                            }
                            case "3" -> {
                                boolean bool = true;
                                String newDestination = null;
                                while (bool) {
                                    System.out.println("Please enter new Destination :   <enter the first letter in upper case>");
                                    newDestination = input.next();
                                    if (!Objects.equals(newDestination, database.flights.info.get(k).getOrigin()) && database.isNumeric(newDestination))
                                        bool = false;
                                    else
                                        System.out.println("Not valid !");
                                }
                                database.flights.update(k, newDestination, number);
                            }
                            case "4" -> {
                                System.out.println("Please enter new Date :");
                                String newDate = input.next();
                                database.flights.update(k, newDate, number);
                            }
                            case "5" -> {
                                System.out.println("Please enter new Time :");
                                String newTime = input.next();
                                database.flights.update(k, newTime, number);
                            }
                            case "6" -> {
                                boolean bool = true;
                                while (bool) {
                                    System.out.println("Please enter new Price :");
                                    String newPrice = input.next();
                                    if (database.isNumeric(newPrice) && Integer.parseInt(newPrice) > 0) {
                                        database.flights.update(k, newPrice, number);
                                        bool = false;
                                    } else
                                        System.out.println("Not valid !");
                                }
                            }
                            case "7" -> {
                                boolean bool = true;
                                while (bool) {
                                    System.out.println("Please enter new capacity for seats :");
                                    String newSeats = input.next();
                                    if (database.isNumeric(newSeats) && Integer.parseInt(newSeats) > 0) {
                                        database.flights.update(k, newSeats, number);
                                        bool = false;
                                    } else
                                        System.out.println("Not valid !");
                                }
                            }
                            default -> {
                                System.out.println("This branch wasn't found !\n");
                                temp = 1;
                            }
                        }
                        if (temp == 0)
                            System.out.println("This action was done successfully.\n");
                        count = 7;
                    }
                }
            }
            if (count==0 && c!=1)
                System.out.println("This Id wasn't found !\n");
        }
    public void showChart(Database database){
        System.out.println("\t | FlightId | Origin | Destination | Date     |  Time  | Price    | Seats |");
        for (int k=0 ; k< database.flights.info.size();k++) {
            System.out.println("\n\t----------------------------------------------------------------------------");
            System.out.println("\t | "+ database.flights.info.get(k).getFlightId() + "\t| "+ database.flights.info.get(k).getOrigin() + "\t | "+ database.flights.info.get(k).getDestination() + "\t  | "+ database.flights.info.get(k).getDate() + "\t| "+ database.flights.info.get(k).getTime() + " | "+database.flights.info.get(k).getPrice() + " | "+ database.flights.info.get(k).getSeat() + " | ");
        }
        System.out.println();
    }
}

