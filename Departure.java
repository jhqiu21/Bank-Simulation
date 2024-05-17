/**
 * This class implements a event when the customer
 * leave the bank after complete his/her service
 *
 * @author QIU JINHANG
 * @version CS2030S AY23/24 Semester 2
 */
public class Departure extends Event {
  private Customer customer;

  public Departure(double departureTime, Customer customer) {
    super(departureTime); 
    this.customer = customer;
  }

  @Override
  public String toString() {
    return super.toString() + String.format(": %s departed", this.customer);
  }

  @Override
  public Event[] simulate() {
    return new Event[] {};
  }
}

