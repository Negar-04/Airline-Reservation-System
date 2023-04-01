import java.util.Scanner;

public class Admin {
    Scanner input = new Scanner(System.in);
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


    public void adminMenu(){

        System.out.println("\t\tAdmin Menu OPTIONS\t\t");
        System.out.println("<1> Add");
        System.out.println("<2> update");
        System.out.println("<3> Remove");
        System.out.println("<4> Flight Schedules");
        System.out.println("<0> Sign out");
        int command = input.nextInt();

        while (command != 0) {

            switch (command) {
                case 1:
                    System.out.println("add");
                case 2:
                    System.out.println("update");
                case 3:
                    System.out.println("remove");
                case 4:
                    System.out.println("flight");
                default:
                    break;
            }
            System.out.println("\t\tAdmin Menu OPTIONS\t\t");
            System.out.println("<1> Add");
            System.out.println("<2> update");
            System.out.println("<3> Remove");
            System.out.println("<4> Flight Schedules");
            System.out.println("<0> Sign out");
            command = input.nextInt();
            }
        }
    }

