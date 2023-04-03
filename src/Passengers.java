import java.util.Scanner;

public class Passengers {
    Scanner input = new Scanner(System.in);
    private String username;
    private String password;
    private int credit;

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

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

    public Passengers(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Passengers() {
    }

    public int printMenu(){
        System.out.println("\t\t\t\t<<PASSENGER MENU OPTIONS>>\t\t");
        System.out.println("<1> Change password");
        System.out.println("<2> Search flight tickets");
        System.out.println("<3> Booking ticket");
        System.out.println("<4> Ticket cancellation");
        System.out.println("<5> Booked tickets");
        System.out.println("<6> Add charge");
        System.out.println("<0> Sign out");
        int command = input.nextInt();

        return command;
    }
    public void passengersMenu(){

        int command = printMenu();

        while (command !=0) {

            switch (command) {
                case 1:
                    System.out.println("change");
                    break;
                case 2:
                    System.out.println("search");
                    break;
                case 3:
                    System.out.println("book");
                    break;
                case 4:
                    System.out.println("cancel");
                    break;
                case 5:
                    System.out.println("ticket");
                    break;
                case 6:
                    System.out.println("charge");
                    break;
                default:
                    break;
            }
            command = printMenu();
        }
    }
}
