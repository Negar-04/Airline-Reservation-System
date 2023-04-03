import java.util.Objects;
import java.util.Scanner;

public class Menu {
    Scanner input = new Scanner(System.in);
    Passengers activity = new Passengers();
    Admin admininformation = new Admin("negar","negar1383");
    Passengers [] information = new Passengers[100];
    int j=0;

    public void startMenu() {
        System.out.println("\n----------------WELCOME TO AIRLINE RESERVATION SYSTEM----------------\n");
        System.out.println("\t\t\t\t\t\t <<MENU OPTIONS>>\t\t\t\n");
        System.out.println("Please choose one of these :");
        System.out.println("<1> Sign in");
        System.out.println("<2> Sign up");
        System.out.println("<3> Exit");

        int command = input.nextInt();
        while (command != 3) {
            switch (command) {
                case 1:
                    signin();
                    break;
                case 2:
                    signup();
                    break;
                default:
                    System.out.println("Not valid\nPlease try again");
                    break;
            }
            System.out.println("\t\t\t\t\t\t <<MENU OPTIONS>>\t\t\t\n");
            System.out.println("Please choose one of these :");
            System.out.println("<1> Sign in");
            System.out.println("<2> Sign up");
            System.out.println("<3> Exit");
            command = input.nextInt();
        }
    }
    public void signup(){
        System.out.println("Please enter username:");
        String username = input.next();

            //System.out.println("This username exists !\nPlease try again.");

        System.out.println("Please enter password:");
        String password = input.next();

        information[j++] = new Passengers(username,password);
    }
    public void signin(){

        System.out.println("Please enter your username:");
        String username = input.next();
        System.out.println("Please enter your password:");
        String password = input.next();

        if (Objects.equals(username,"negar") && Objects.equals(password,"negar1383"))
                    admininformation.adminMenu();
        int count=0;
        for (int k=0; k<j; k++) {
            if (Objects.equals(information[k].getUsername(), username) && Objects.equals(information[k].getPassword(), password)) {
                activity.passengersMenu();
                count=1;
            }
        }
        if (count==0)
            System.out.println("Not valid !\nPlease sign up first.");

    }
}
