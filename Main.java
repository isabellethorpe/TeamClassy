package BCPA;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class contains the main method to run the
 * user interface which allows a person to make
 * a booking. We have used test data to give the
 * user initial choices.
 *
 * @author Team Classy
 * @version 8
 */
public class Main {

    // We have used test data for venue and shows to make
    // it easier to demonstrate a booking.
    public static void main(String args[])
    {
        // User input
        Scanner userInput = new Scanner(System.in);

        // Venue test data and capacity
        Venue venueBCPA = new Venue("BCPA", 100);

        // Show test data
        Show showCats = new Show("Cats", "January", venueBCPA);
        Show showChicago = new Show("Chicago", "Feburary", venueBCPA);
        Show showBookOfMormon = new Show("Book of Mormon", "March", venueBCPA);
        Show show222 = new Show("2:22", "April", venueBCPA);

        // Adding the test data
        venueBCPA.addShow(showCats);
        venueBCPA.addShow(showChicago);
        venueBCPA.addShow(showBookOfMormon);
        venueBCPA.addShow(show222);

        // Whilst the programme is running
        while (!(userInput.equals(true)))
        {
            // Website baner
            System.out.println("Welcome to the BCPA theatre website!");

            while (!(userInput.equals(true)))
            {
                // Supply user with options
                System.out.println("\nPlease select an option:\n" + "\nType \"Sign up\" to sign up.\n"
                    + "Type \"Shows\" to see our current and upcoming performances.");
                System.out.println();
                // Switch statement used - if there is a match before break,
                // the associated block of code is executed
                switch (userInput.nextLine().toUpperCase())
                {
                        // If the user enters to make a booking
                    case "SIGN UP":

                        // Creates a new person
                        Person person = new Person();

                        // Allows user to enter details
                        person.enterDetails();

                        // Once details entered, they can select a show from the list
                        System.out.println("Please select a show from the following list:");
                        System.out.println();
                        venueBCPA.printShows();

                        // ToDo:
                        // Can go in Person class, make more specific
                        Show show = new Show();

                        // Show test data
                        switch (userInput.nextLine().toUpperCase())
                        {
                            case "CATS":
                                show = showCats;
                                break;
                            case "CHICAGO":
                                show = showChicago;
                                break;
                            case "BOOK OF MORMON":
                                show = showBookOfMormon;
                                break;
                            case "2:22":
                                show = show222;
                                break;
                            default:
                                break;
                        }

                        // User confirmation 
                        System.out.println("\nYou have selected: " + show.showName + "\n");

                        // Creates seat for user to pick from
                        // Persons seat

                        System.out.println("The seats available are shown below.\n");
                        // Displays seating chart
                        //Venue's responsbility >move to venue

                        char[][] seatingPlanArray = venueBCPA.displaySeats();
                        ArrayList<Seat> seats = person.reserveSeat(seatingPlanArray, venueBCPA);

                        // Sets and returns ticket details to user
                        for (Seat seat : seats)
                        {
                            Ticket ticket = new Ticket(person, show, venueBCPA, seat);
                            ticket.printTicket();
                        }
                        break;
                    case "SHOWS":
                        System.out.println("\nShows listed below: ");
                        venueBCPA.printShows();
                        break;
                    default:
                        break;
                }
            }
            userInput.close();
        }
    }
}