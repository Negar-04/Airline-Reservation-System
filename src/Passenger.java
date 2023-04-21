public class Passenger {
    private final String username;
    private String password;
    private String credit;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public Passenger(String username, String password, String credit) {
        this.username = username;
        this.password = password;
        this.credit = credit;
    }
}


