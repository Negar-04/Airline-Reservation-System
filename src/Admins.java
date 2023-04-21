import java.util.ArrayList;

public class Admins {
    ArrayList<Admin> admins;

    public Admins() {
        this.admins = new ArrayList<>();
        admins.add(0, new Admin());
    }
}
