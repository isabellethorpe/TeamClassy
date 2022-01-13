package BCPA;

/**
 * The Show class allows a show name and date to be set
 * and prints of the details of a show
 *
 * @author Team Classy
 * @version 6
 */
public class Show{

    String showName;
    String showDate;

    public Show(String showName, String showDate, Venue venue)
    {
        this.showName = showName;
        this.showDate = showDate;
        //this.venue = venue;
    }
    // Example of Polymorphism
    public Show() {}
    // Prints show name and date
    public void printShow()
    {
        System.out.println("Show: " + showName + "    |    " + "Date: " + showDate);
    }
}
