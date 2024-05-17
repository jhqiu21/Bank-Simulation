/**
 * This class implements events when the customer
 * join the bank counter queue and wait
 *
 * @author QIU JINHANG
 * @version CS2030S AY23/24 Semester 2
 */
public class JoinCounterQueue extends Event {
  private Customer customer;
  private BankCounter counterToWait;

  public JoinCounterQueue(Customer customer, BankCounter counterToWait, double joinTime) {
    super(joinTime);
    this.customer = customer;
    this.counterToWait = counterToWait;
  }

  @Override
  public String toString() {
    return super.toString()
           + String.format(": %s joined counter queue ", this.customer) 
           + "(" + String.format("at %s", this.counterToWait) + ")";
  }   

  @Override
  public Event[] simulate() {
    counterToWait.joinCounterQueue(this.customer);
    return new Event[]{ }; 
  }
}
