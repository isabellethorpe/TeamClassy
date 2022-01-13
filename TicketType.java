package BCPA;

/**
 * This enum class sets the price of an adult,
 * senior and child ticket
 *
 * @author Team Classy
 * @version 4
 */
public enum TicketType {
    SENIOR(9.50D),

    STUDENT(8.90D),

    ADULT(12.00D),

    CHILD(6.00D);

    private final double price;

    String ticketTypeString;
    // Sets price 
    TicketType(double price)
    {
        this.price = price;
    }

    // Gets price
    public double getPrice()
    {
        return price;
    }

    // Gets total price of number of tickets
    public double getCalculatedPrice(int ticketAmount)
    {
        return price * ticketAmount;
    }
}
