package BCPA;

import java.util.Scanner;
import java.util.*;

/**
 * The Person class  allows a user to enter their 
 * details which are used for making a booking
 *
 * @author Team Classy
 * @version 8
 * 
 */
public class Person {

    private String firstName;
    private String lastName;
    private String houseNumber;
    private String streetName;
    private String city;
    private String postcode;
    public Person person;

    Show selectedShow;

    String choice;

    Scanner userInput;

    String ticketTypeString;
    private ArrayList<Seat> seats;
    TicketType ticketType;

    // Sets first name
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    // Sets last name
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    // Sets house number
    public void setHouseNumber(String houseNumber)
    {
        this.houseNumber = houseNumber;
    }

    // Sets street name
    public void setStreetName(String streetName)
    {
        this.streetName = streetName;
    }

    // Sets city
    public void setCity(String city)
    {
        this.city = city;
    }

    // Sets postcode
    public void setPostcode(String postcode)
    {
        this.postcode = postcode;
    }

    // This method allows a person to enter their details
    public Person enterDetails()
    {

        Boolean detailsCorrectBoolean = false;
        while(!detailsCorrectBoolean)
        {
            Scanner userInput = new Scanner(System.in);
            System.out.println("\nPlease enter your details...");
            System.out.println();

            System.out.print("First name: ");  
            System.out.println();
            setFirstName(userInput.nextLine().toUpperCase());

            System.out.print("Last name: ");
            System.out.println();
            setLastName(userInput.nextLine().toUpperCase());

            System.out.print("House Number: "); 
            System.out.println();
            setHouseNumber(userInput.nextLine().toUpperCase());

            System.out.print("Street Name: ");  
            System.out.println();
            setStreetName(userInput.nextLine().toUpperCase());

            System.out.print("City: ");  
            System.out.println();
            setCity(userInput.nextLine().toUpperCase());

            System.out.print("Postcode: ");  
            System.out.println();
            setPostcode(userInput.nextLine().toUpperCase());

            System.out.println();
            System.out.println("Are the above details correct? \n" +
                "Please type \"Yes\" or \"No\".");
            System.out.println();
            String detailsCorrect = userInput.nextLine().toUpperCase();

            // The person can confirm whether their details
            // are correct or not. If they are not, it asks
            // the user to enter their details again from 
            // the top
            if (detailsCorrect.equals("YES"))
            {
                System.out.println();
                detailsCorrectBoolean = true;
            }
            else
            {
                detailsCorrectBoolean = false;
            }
        }
        return person;
    }

    public Show selectShow(Show show)
    {
        // venue.printShows();
        System.out.print("Select Show : ");
        choice = userInput.nextLine().toUpperCase();
        //for(choice == "0")
        selectedShow = show;
        // While loop, if statement to check if choice is out of bounds
        return selectedShow;
    }

    public ArrayList<Seat> reserveSeat(char[][] seatingPlanArray, Venue venueBCPA)
    {
        // new array
        seats = new ArrayList<Seat>();
        Boolean reserveSeatsBoolean = true;
        while(reserveSeatsBoolean)
        {   
            Scanner userInput = new Scanner(System.in);

            // User enters the row number of choice
            System.out.print("\nPlease enter the row you would like to sit in: \n");
            System.out.println();
            int rowNumber = (char) Integer.parseInt(userInput.nextLine());

            // User enters the column number of choice
            System.out.print("\nPlease enter the column you would like to sit in: \n");
            System.out.println();
            int columnNumber = (char) Integer.parseInt(userInput.nextLine());
            System.out.println();
            // User selects ticket type
            System.out.println("Please select a ticket type for your seat:\n\n"
                + "-" +TicketType.ADULT + "\n"
                + "-" +TicketType.SENIOR + "\n"
                + "-" +TicketType.STUDENT + "\n"
                + "-" +TicketType.CHILD);

            System.out.println();
            ticketTypeString = userInput.nextLine().toUpperCase();
            System.out.println();
            if (ticketTypeString.equals("ADULT")) 
            {
                ticketType = TicketType.ADULT;
            }
            else if (ticketTypeString.equals("SENIOR")) 
            {
                ticketType = TicketType.SENIOR;
            }
            else if (ticketTypeString.equals("STUDENT")) 
            {
                ticketType = TicketType.STUDENT;
            }
            else if (ticketTypeString.equals("CHILD")) 
            {
                ticketType = TicketType.CHILD;
            }

            seatingPlanArray[rowNumber - 1][columnNumber - 1] = 'X';
            for (int row = 0; row < seatingPlanArray.length; row++)
            {
                for (int col = 0; col < seatingPlanArray[row].length; col++) 
                {
                    // Prints seat plan with updated X where user 
                    // has selected a specific seat
                    System.out.print(seatingPlanArray[row][col]);
                }
                System.out.println();
            }

            // Sets seat with row number, column number and ticket
            // type select
            Seat seat = new Seat(rowNumber, columnNumber, ticketType);
            // rowNumber = rowNumber;
            // columnNumber = columnNumber;
            // ticketType = ticketType;

            venueBCPA.addSeat(seats, seat);

            // Prints seat details
            seat.printSeatDetails(seats);
            System.out.println("\nWould you like to reserve more seats?");
            System.out.println();
            // User can choose to reserve more seats or not
            String reserveMoreSeats = userInput.nextLine().toUpperCase();
            if (reserveMoreSeats.equals("NO"))
            {
                reserveSeatsBoolean = false;
            }
            else
            {
                reserveSeatsBoolean = true;
            }
        }
        for (Seat seat : seats) {
            seat.printSeatDetails(seats);
        }
        return seats;
    }
    // Prints details of the person
    public void printPersonDetails()
    {
        System.out.println("Name:   " + firstName + " " + lastName);
    }
}