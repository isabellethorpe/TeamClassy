package BCPA;

import java.util.ArrayList;

/**
 * The Venue class gets a list of shows for the 
 * venue, and allows a user to select a show.
 * Shows may also be added
 *
 * @author Team Classy
 * @version 8
 */
public class Venue {

    private String venueName;
    int totalSeatCapacity;

    char[][] seatingPlanArray;

    private ArrayList<Show> shows;

    public char[][] getSeatingPlan()
    {
        char[][] seatingPlanArray = new char[4][8];
        return seatingPlanArray;
    }

    // Sets venue name and seat capacity
    public Venue(String venueName, int totalSeatCapacity)
    {
        //this.venueName = venueName;
        this.totalSeatCapacity = totalSeatCapacity;
        shows = new ArrayList<Show>();
    }

    // Allows a show to be added
    public void addShow(Show show)
    {
        shows.add(show);
    }

    public void addSeat(ArrayList<Seat> seats, Seat seat)
    {
        seats.add(seat);
    }

    // Prints all the shows in list
    public void printShows()
    {
        for (Show show : shows)
        {
            show.printShow();
        }
    }

    public char[][] displaySeats(){

        seatingPlanArray = getSeatingPlan();

        // For each column set a 0 
        for (int col = 0; col < seatingPlanArray.length; col++)
        {
            // For each row set a 0
            for (int row = 0; row < seatingPlanArray[col].length; row++)
            {
                seatingPlanArray[col][row] = '0';
                // Prints the seating plan, an array of 0's
                System.out.print(seatingPlanArray[col][row]);
            }
            System.out.println();
        }
        // Return the seating plan
        return seatingPlanArray;
    }

    // Prints venue name
    public void printVenueName()
    {
        System.out.println("Venue: " + venueName);
    }
}
