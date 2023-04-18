public class Database {
    Admins admins = new Admins();
    Passengers passengers = new Passengers();
    Flights flights = new Flights();
    Tickets tickets = new Tickets();

    public boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
