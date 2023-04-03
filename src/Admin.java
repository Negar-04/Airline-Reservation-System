import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Admin {
    Scanner input = new Scanner(System.in);
    ArrayList<Flight> info = new ArrayList<>();
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Admin(String username, String password) {
        this.username = "negar";
        this.password = "negar1383";
    }
    int c=1;

    public void adminMenu(){

        if (c==1)
        defaultInfo(info);
        c=7;

        System.out.println("\t\t\t\t\t\t<<Admin Menu OPTIONS>>\t\t");
        System.out.println("<1> Add");
        System.out.println("<2> update");
        System.out.println("<3> Remove");
        System.out.println("<4> Flight Schedules");
        System.out.println("<0> Sign out");
        int command = input.nextInt();

        while (command != 0) {

            switch (command) {
                case 1:
                    addFlight(info);
                    break;
                case 2:
                    update(info);
                    break;
                case 3:
                    System.out.println("Please enter the flightId that you want to remove :");
                    String removeId = input.next();
                    remove(info,removeId);
                    break;
                case 4:
                    showChart(info);
                    break;
                default:
                    System.out.println("Not valid !\n Please try again.");
                    break;
            }
            System.out.println("\t\t\t\t\t\t<<Admin Menu OPTIONS>>\t\t");
            System.out.println("<1> Add");
            System.out.println("<2> update");
            System.out.println("<3> Remove");
            System.out.println("<4> Flight Schedules");
            System.out.println("<0> Sign out");
            command = input.nextInt();
            }
        }
        public void showChart(ArrayList<Flight> info){
             System.out.println("\t | FlightId | Origin | Destination | Date     |  Time  | Price    | Seats |");
             for (int k=0 ; k< info.size();k++) {
                System.out.println("\n\t----------------------------------------------------------------------------");
                System.out.println("\t | "+ info.get(k).getFlightId() + "\t| "+ info.get(k).getOrigin() + "\t | "+ info.get(k).getDestination() + "\t  | "+ info.get(k).getDate() + "\t| "+ info.get(k).getTime() + " | "+info.get(k).getPrice() + " | "+ info.get(k).getSeat() + " | ");
             }
            System.out.println();
        }
        public void defaultInfo(ArrayList<Flight> info){

        Flight info1 = new Flight("WX-12","Yazd","Tehran","1401-12-10","12:30",700000,51);
        Flight info2 = new Flight("WZ-15","Mashhad","Ahvaz","1401-12-11","8:00",900000,245);
        Flight info3 = new Flight("BG-22","Shiraz","Tabriz","1401-12-12","22:30",1100000,12);
        Flight info4 = new Flight("bg-20","Tehran","Kish","1402-01-20","22:00",1359000,90);
        Flight info5 = new Flight("LK-11","Esfahan","Tabriz","1402-01-26","08:10",1009000,121);
        Flight info6 = new Flight("wx-12","Tehran","Yazd","1402-02-2","00:30",645000,207);
        Flight info7 = new Flight("BG-28","Shiraz","Kermanshah","1402-01-28","10:45",1770000,64);
        Flight info8 = new Flight("AB-12","Ahvaz","Tehran","1402-02-06","16:30",985000,29);
        Flight info9 = new Flight("wz-10","Kish","Yazd","1402-01-31","17:00",1200000,62);
        Flight info10 = new Flight("lk-14","Mashhad","Yazd","1402-02-11","21:00",2100000,31);
        info.add(0,info1);
        info.add(1,info2);
        info.add(2,info3);
        info.add(3,info4);
        info.add(4,info5);
        info.add(5,info6);
        info.add(6,info7);
        info.add(7,info8);
        info.add(8,info9);
        info.add(9,info10);

        }
        public void addFlight(ArrayList<Flight> info){
            System.out.println("please enter flightId :");
            String flightId = input.next();
            System.out.println("please enter origin :");
            String origin = input.next();
            System.out.println("please enter destination :");
            String destination = input.next();
            System.out.println("please enter date :");
            String date = input.next();
            System.out.println("please enter time :");
            String time = input.next();
            System.out.println("please enter price :");
            int price = input.nextInt();
            System.out.println("please enter seats :");
            int seat = input.nextInt();
            Flight addedInfo= new Flight(flightId,origin,destination,date,time,price,seat);
            info.add(info.size(),addedInfo);
        }
        public void remove(ArrayList<Flight> info ,String removeId){
            int count=0;
            for (int k=0; k< info.size();k++) {
                if (Objects.equals(removeId,info.get(k).getFlightId())) {
                    info.remove(k);
                    count=7;
                }
            }
            if (count==0)
                System.out.println("This Id wasn't found !");
        }
        public void update(ArrayList<Flight> info){
            System.out.println("Please enter the flightId that you want to update :");
            String updateId = input.next();
            int count=0;
            for (int k=0; k< info.size();k++) {
                if (Objects.equals(updateId, info.get(k).getFlightId())) {
                    System.out.println("Which branch of flight do you want to update ?");
                    System.out.println("1-FlightId\n2-origin\n3-Destination\n4-Date\n5-Time\n6-Price\n7-seats");
                    System.out.println("Please enter the number :");
                    int number = input.nextInt();

                    switch (number){
                        case 1 :
                            System.out.println("Please enter new Id :");
                            String newId = input.next();
                            info.get(k).setFlightId(newId);
                            break;
                        case 2 :
                            System.out.println("Please enter new origin :");
                            String newOrigin = input.next();
                            info.get(k).setOrigin(newOrigin);
                            break;
                        case 3 :
                            System.out.println("Please enter new Destination :");
                            String newDestination = input.next();
                            info.get(k).setDestination(newDestination);
                            break;
                        case 4 :
                            System.out.println("Please enter new Date :");
                            String newDate = input.next();
                            info.get(k).setDate(newDate);
                            break;
                        case 5 :
                            System.out.println("Please enter new Time :");
                            String newTime = input.next();
                            info.get(k).setTime(newTime);
                            break;
                        case 6 :
                            System.out.println("Please enter new Price :");
                            int newPrice = input.nextInt();
                            info.get(k).setPrice(newPrice);
                            break;
                        case 7 :
                            System.out.println("Please enter new capacity for seats :");
                            int newSeats = input.nextInt();
                            info.get(k).setSeat(newSeats);
                            break;
                        default:
                            System.out.println("This branch wasn't found.");
                            break;
                    }
                    count=7;
                }
            }
            if (count==0)
                System.out.println("This Id wasn't found.");
        }
    }

