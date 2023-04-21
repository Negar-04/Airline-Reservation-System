import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Tickets {
    String[] ticketArray = new String[1000];
    ArrayList<Ticket> tickets;

    public Tickets() {
        this.tickets = new ArrayList<>();
    }

    int i1 = 0;

    /**
     * add the information of purchased ticket into arraylist of tickets and give the ticketId to passenger
     *
     * @param k        the related index of flight that passenger wants to book
     * @param j1       the related index of each user in the array of passengers
     * @param database has the requisite information
     * @return ticketId
     */

    public int buyTicket(int k, int j1, Database database) {

        Random rand = new Random();
        ticketArray[i1] = String.valueOf(rand.nextInt(2500) + 1000);

        for (int j = 0; j < i1; j++) {
            if (Objects.equals(ticketArray[j], ticketArray[i1])) {
                ticketArray[i1] = String.valueOf(rand.nextInt(2500) + 1000);
                j = -1;
            }
        }

        Ticket ticketInfo = new Ticket(ticketArray[i1], new Flight(database.flights.info.get(k).getFlightId(), database.flights.info.get(k).getOrigin(), database.flights.info.get(k).getDestination(), database.flights.info.get(k).getDate(), database.flights.info.get(k).getTime(), database.flights.info.get(k).getPrice(), database.flights.info.get(k).getSeat()), new Passenger(database.passengers.information[j1].getUsername(), database.passengers.information[j1].getPassword(), database.passengers.information[j1].getCredit()));
        tickets.add(tickets.size(), ticketInfo);
        i1++;
        return i1;
    }

    /**
     * receive the flightId from passengers and book ticket for them
     *
     * @param flightId that has gotten from passenger to reserve flight
     * @param j        the related index of each user in the array of passengers
     * @param database has the requisite information
     * @return auxiliary variable to print appropriate message or show ticketId
     */
    public int bookTicket(String flightId, int j, Database database) {

        for (int k = 0; k < database.flights.info.size(); k++) {
            if (Objects.equals(flightId, database.flights.info.get(k).getFlightId())) {
                int emptySeat = Integer.parseInt(database.flights.info.get(k).getSeat());
                if (emptySeat <= 0)
                    return -1;

                int newPrice = Integer.parseInt(database.flights.info.get(k).getPrice());
                int newCharge = Integer.parseInt(database.passengers.information[j].getCredit());
                if (newPrice > newCharge)
                    return -2;

                int seat = Integer.parseInt(database.flights.info.get(k).getSeat());
                seat--;
                String newSeat = String.valueOf(seat);
                database.flights.info.get(k).setSeat(newSeat);

                int distance = Integer.parseInt(database.passengers.information[j].getCredit()) - Integer.parseInt(database.flights.info.get(k).getPrice());
                database.passengers.information[j].setCredit(String.valueOf(distance));
                return buyTicket(k, j, database);
            }
        }
        return 0;
    }

    /**
     * remove booked tickets , return charge of the user into his / her account and add one seat into the capacity of seats
     *
     * @param ticketId that has gotten from passenger to cancel reservation
     * @param j        the related index of each user in the array of passengers
     * @param database has the requisite information
     * @return auxiliary variable to print appropriate message
     */
    public int cancellation(String ticketId, int j, Database database) {
        int count = 0;
        String flightId;

        for (int i = 0; i < database.tickets.tickets.size(); i++) {
            if (Objects.equals(ticketId, database.tickets.tickets.get(i).getTicketId())) {
                count = 1;
                flightId = database.tickets.tickets.get(i).getFlight().getFlightId();
                database.tickets.tickets.remove(i);
                i--;

                for (int k = 0; k < database.flights.info.size(); k++) {
                    if (Objects.equals(database.flights.info.get(k).getFlightId(), flightId)) {
                        int seat = Integer.parseInt(database.flights.info.get(k).getSeat());
                        seat++;
                        String newSeat = String.valueOf(seat);
                        database.flights.info.get(k).setSeat(newSeat);

                        int distance = Integer.parseInt(database.passengers.information[j].getCredit()) + Integer.parseInt(database.flights.info.get(k).getPrice());
                        database.passengers.information[j].setCredit(String.valueOf(distance));
                        break;
                    }
                }
            }
        }
        return count;
    }
}
