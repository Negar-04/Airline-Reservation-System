public class Ticket {
    private final String ticketId;
    private final Flight flight;
    private final Passenger passengers;

    public String getTicketId() {
        return ticketId;
    }

    public Flight getFlight() {
        return flight;
    }

    public Passenger getPassengers() {
        return passengers;
    }

    public Ticket(String ticketId, Flight flight, Passenger passengers) {
        this.ticketId = ticketId;
        this.flight = flight;
        this.passengers = passengers;
    }
}
