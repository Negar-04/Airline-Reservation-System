public class Ticket {
    private String ticketId;
    private Flight flight;
    private Passenger passengers;

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger getPassengers() {
        return passengers;
    }

    public void setPassengers(Passenger passengers) {
        this.passengers = passengers;
    }

    public Ticket(String ticketId, Flight flight, Passenger passengers) {
        this.ticketId = ticketId;
        this.flight = flight;
        this.passengers = passengers;
    }
}
