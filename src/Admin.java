public class Admin {
    private String username = "negar";
    private String password = "negar1383";

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

    public Admin() {
    }
    public void adminMenu(){

        System.out.println("\t\tAdmin Menu OPTIONS\t\t");
        System.out.println("<1> A");
    }
}
