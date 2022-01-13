package BCPA;
import java.util.ArrayList;

/**
 * This class contains allows sets the details
 * for a ticket and prints the ticket
 * 
 * @author Team Classy
 * @version 7
 */
public class Ticket {

    Person person;
    Show show;
    Venue venue;
    Seat seat;

    ArrayList<Seat> seats;

    // Allows ticket details to be set after user input
    // Returns details as information printer on ticket
    public Ticket(Person person, Show show, Venue venue, Seat seat)
    {
        this.person = person;
        this.show = show;
        this.venue = venue;
        this.seat = seat;
    }

    public void printTicket()
    {
        {
            System.out.println();
            System.out.println("********************************");
            System.out.println("************ TICKET ************");
            System.out.println("********************************");
            person.printPersonDetails();
            show.printShow();
            venue.printVenueName();
            seat.printSeatDetails(seats);
            System.out.println("********************************");
            System.out.println();
            return;
        }
    }
}
