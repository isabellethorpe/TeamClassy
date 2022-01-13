package BCPA;

import java.util.*;

/**
 * This class allows a user to select a seat by viewing
 * a seating plan, entering the row number, column number
 * and ticket type and returning a seating plan with their
 * selected seat displayed as reserved with an "X"
 * 
 * @author Team Classy
 * @version 8
 */
public class Seat {

    int columnNumber;
    int rowNumber;

    private ArrayList<Seat> seats;

    TicketType ticketType;

    //public Seat(){}

    // Allows set details to be set after user input
    public Seat(int rowNumber, int columnNumber, TicketType ticketType) {
        this.columnNumber = columnNumber;
        this.rowNumber = rowNumber;
        this.ticketType = ticketType;
    }

    // Prints seat details including ticket type
    public void printSeatDetails(ArrayList<Seat> seats)
    {
        System.out.println("\nSeat: " + "Row " + rowNumber + ","+ "Column "
            + columnNumber + ", " + "Price " + ticketType.getPrice());
    }
}
