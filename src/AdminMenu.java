import java.util.Objects;
import java.util.Scanner;
public class AdminMenu {
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
            boolean bool = true;
            while (bool) {
                System.out.println("please enter origin :  <enter the first letter in upper case>");
                origin = input.next();
                if (database.checkLetters(origin))
                    bool = false;
                else
                    System.out.println("Not valid !");
            }
            bool = true;
            String destination = null;
            while (bool) {
                System.out.println("please enter destination :   <enter the first letter in upper case>");
                destination = input.next();
                if (!Objects.equals(destination, origin) && database.checkLetters(destination))
                    bool = false;
                else
                    System.out.println("Not valid !");
            }
            bool = true;
            String date = null;
            while (bool) {
                System.out.println("please enter date :    <enter zero wherever required>");
                date = input.next();
                if (database.checkDate(date))
                    bool = false;
                else
                    System.out.println("Not valid !");
            }
            bool = true;
            String time = null;
            while (bool) {
                System.out.println("please enter time :    <enter zero wherever required>");
                time = input.next();
                if (database.checkTime(time))
                    bool = false;
                else
                    System.out.println("Not valid !");
            }
            bool = true;
            String price = null;
            while (bool) {
                System.out.println("please enter price :");
                price = input.next();
                if (database.isNumeric(price) && Integer.parseInt(price) > 0)
                    bool = false;
                else
                    System.out.println("Not valid !");
            }
            bool = true;
            String seat = null;
            while (bool) {
                System.out.println("please enter seats :");
                seat = input.next();
                if (database.isNumeric(seat) && Integer.parseInt(seat) > 0)
                    bool = false;
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
        if (count==0 && temp==0)
            System.out.println("This Id wasn't found !\n");
        if (count!=0)
            System.out.println("This action was done successfully.\n");
        }
        public void update(Database database){
            System.out.println("Please enter the flightId that you want to update :");
            String updateId = input.next();
            int c=0,count=0,temp=0;
            for (int i=0;i<database.tickets.tickets.size();i++){
                if (Objects.equals(database.tickets.tickets.get(i).getFlight().getFlightId(), updateId)){
                    System.out.println("You can't update this flight ; it has already booked.\n");
                    c=1;
                    break;
                }
            }
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
                                    if (!Objects.equals(newOrigin, database.flights.info.get(k).getDestination()) && database.checkLetters(newOrigin))
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
                                    if (!Objects.equals(newDestination, database.flights.info.get(k).getOrigin()) && database.checkLetters(newDestination))
                                        bool = false;
                                    else
                                        System.out.println("Not valid !");
                                }
                                database.flights.update(k, newDestination, number);
                            }
                            case "4" -> {
                                boolean bool = true;
                                String newDate = null;
                                while (bool) {
                                    System.out.println("Please enter new Date :     <enter zero wherever required>");
                                    newDate = input.next();
                                    if (database.checkDate(newDate))
                                        bool = false;
                                    else
                                        System.out.println("Not valid !");
                                }
                                database.flights.update(k, newDate, number);
                            }
                            case "5" -> {
                                boolean bool = true;
                                String newTime = null;
                                while (bool) {
                                    System.out.println("Please enter new Time :     <enter zero wherever required>");
                                    newTime = input.next();
                                    if (database.checkTime(newTime))
                                        bool = false;
                                    else
                                        System.out.println("Not valid !");
                                }
                                database.flights.update(k, newTime, number);
                            }
                            case "6" -> {
                                boolean bool = true;
                                String newPrice = null;
                                while (bool) {
                                    System.out.println("Please enter new Price :");
                                    newPrice = input.next();
                                    if (database.isNumeric(newPrice) && Integer.parseInt(newPrice) > 0)
                                        bool = false;
                                    else
                                        System.out.println("Not valid !");
                                }
                                database.flights.update(k, newPrice, number);
                            }
                            case "7" -> {
                                boolean bool = true;
                                String newSeats = null;
                                while (bool) {
                                    System.out.println("Please enter new capacity for seats :");
                                    newSeats = input.next();
                                    if (database.isNumeric(newSeats) && Integer.parseInt(newSeats) > 0)
                                        bool = false;
                                    else
                                        System.out.println("Not valid !");
                                }
                                database.flights.update(k, newSeats, number);
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
        System.out.println("| FlightId |    Origin     |  Destination  |    Date    | Time  |    Price   |  Seats |");
        for (int k=0 ; k< database.flights.info.size();k++) {
            System.out.print("---------------------------------------------------------------------------------------\n");
            System.out.printf("|%-10s|%-15s|%-15s|%-12s|%-7s|%-12s|%-8s| %n",database.flights.info.get(k).getFlightId(),database.flights.info.get(k).getOrigin(),database.flights.info.get(k).getDestination(),database.flights.info.get(k).getDate(),database.flights.info.get(k).getTime(),database.flights.info.get(k).getPrice(),database.flights.info.get(k).getSeat());
        }
        System.out.println();
    }
}
