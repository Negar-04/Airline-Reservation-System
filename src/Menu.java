import java.util.Objects;
import java.util.Scanner;

public class Menu {
    Scanner input = new Scanner(System.in);
    Passengers activity = new Passengers();
    Admin admininformation = new Admin("negar","negar1383");
    Passengers [] information = new Passengers[100];
    int j=0;

    public void startMenu() {
        System.out.println("WELCOME TO AIRLINE RESERVATION SYSTEM\n");
        System.out.println("\t\t MENU OPTIONS\t\t\t\n");
        System.out.println("Please choose one of these :");
        System.out.println("<1> Sign in");
        System.out.println("<2> Sign up");
        System.out.println("<3> Exit");

        int command = input.nextInt();
        while (command != 3) {
            switch (command) {
                case 1:
                    System.out.println("sign in");
                    signin();
                    break;
                case 2:
                    System.out.println("sign up");
                    signup();

                    break;
                default:
                    break;
            }

            System.out.println("Please choose one of these :");
            System.out.println("<1> Sign in");
            System.out.println("<2> Sign up");
            System.out.println("<3> Exit");
            command = input.nextInt();
        }
    }
    public void signup(){
        System.out.println("username:");
        String username = input.next();
        System.out.println("pass:");
        String password = input.next();

        information[j++] = new Passengers(username,password);
    }
    public void signin(){
        System.out.println("username:");
        String username = input.next();
        System.out.println("pass:");
        String password = input.next();

        if (Objects.equals(username,"negar") && Objects.equals(password,"negar1383"))
                    admininformation.adminMenu();

        for (int k=0; k<j; k++)
            if (Objects.equals(information[k].getUsername(),username) && Objects.equals(information[k].getPassword(),password))
                activity.passengersMenu();


    }
}
