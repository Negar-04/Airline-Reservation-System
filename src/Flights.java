import java.util.ArrayList;
import java.util.Objects;

public class Flights {
    ArrayList<Flight> info;

    public Flights() {
        this.info = new ArrayList<>();
    }

    /**
     * fill the arraylist of flights with default flights
     */
    public void defaultInfo() {

        Flight info1 = new Flight("WX-12", "Yazd", "Tehran", "1401/12/10", "12:30", "700000", "51");
        Flight info2 = new Flight("WZ-15", "Mashhad", "Ahvaz", "1401/12/11", "8:00", "900000", "245");
        Flight info3 = new Flight("BG-22", "Shiraz", "Tabriz", "1401/12/12", "22:30", "1100000", "12");
        Flight info4 = new Flight("bg-20", "Tehran", "Kish", "1402/01/20", "22:00", "1359000", "90");
        Flight info5 = new Flight("LK-11", "Isfahan", "Tabriz", "1402/01/26", "08:10", "1009000", "121");
        Flight info6 = new Flight("wx-12", "Mashhad", "Yazd", "1402/02/04", "00:30", "645000", "14");
        Flight info7 = new Flight("BG-28", "Shiraz", "Kermanshah", "1402/01/28", "10:45", "1770000", "64");
        Flight info8 = new Flight("AB-12", "Ahvaz", "Tehran", "1402/02/06", "16:30", "985000", "29");
        Flight info9 = new Flight("wz-10", "Kish", "Yazd", "1402/01/31", "17:00", "1200000", "62");
        Flight info10 = new Flight("lk-14", "Mashhad", "Yazd", "1402/02/11", "21:00", "2100000", "31");
        info.add(0, info1);
        info.add(1, info2);
        info.add(2, info3);
        info.add(3, info4);
        info.add(4, info5);
        info.add(5, info6);
        info.add(6, info7);
        info.add(7, info8);
        info.add(8, info9);
        info.add(9, info10);
    }

    /**
     * fix and set information in arraylist of flights
     *
     * @param flightId    of the desired flight
     * @param origin      of the desired flight
     * @param destination of the desired flight
     * @param date        of the desired flight
     * @param time        of the desired flight
     * @param price       of the desired flight
     * @param seat        of the desired flight
     */
    public void addFlight(String flightId, String origin, String destination, String date, String time, String price, String seat) {

        Flight addedInfo = new Flight(flightId, origin, destination, date, time, price, seat);
        info.add(info.size(), addedInfo);

    }

    /**
     * remove the flight based on removeId that has gotten in admin menu
     *
     * @param removeId that has gotten from admin in admin menu
     * @return auxiliary variable to print appropriate message
     */

    public int remove(String removeId) {

        int count = 0;
        for (int k = 0; k < info.size(); k++) {
            if (Objects.equals(removeId, info.get(k).getFlightId())) {
                info.remove(k);
                k--;
                count = 7;
            }
        }
        return count;
    }

    /**
     * fix the information
     *
     * @param k            the related index of flight that admin wants to update
     * @param updateBranch the replacement quantity
     * @param branch       the branch of the flight that should be updated
     */
    public void update(int k, String updateBranch, String branch) {

        switch (branch) {
            case "1" -> info.get(k).setFlightId(updateBranch);
            case "2" -> info.get(k).setOrigin(updateBranch);
            case "3" -> info.get(k).setDestination(updateBranch);
            case "4" -> info.get(k).setDate(updateBranch);
            case "5" -> info.get(k).setTime(updateBranch);
            case "6" -> info.get(k).setPrice(updateBranch);
            case "7" -> info.get(k).setSeat(updateBranch);
        }
    }
}
