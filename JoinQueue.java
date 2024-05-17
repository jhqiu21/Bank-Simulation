/**
 * This class implements process of a customer
 * join the bank queue when all bank counters' queue
 * is full
 *
 * @author QIU JINHANG
 * @version CS2030S AY23/24 Semester 2
 */
public class JoinQueue extends Event {
  private Customer customer;
  private Bank bank;

  public JoinQueue(Customer customer, Bank bank, double joinTime) {
    super(joinTime);
    this.customer = customer;
    this.bank = bank;
  }

  @Override
  public String toString() {
    return super.toString() +
           String.format(": %s joined bank queue", this.customer) +
           String.format(" %s", this.bank.printQueue());
  }
  
  @Override
  public Event[] simulate() {
    this.bank.joinQueue(this.customer);
    return new Event[]{ };
  }
}

