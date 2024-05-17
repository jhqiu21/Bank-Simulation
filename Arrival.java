/**
 * This class implements arrival process
 * of the customer.
 *
 * @author QIU JINHANG
 * @version CS2030S AY23/24 Semester 2
 */

public class Arrival extends Event {
  private Bank bank;
  private Customer customer;

  public Arrival(Bank bank, Customer customer) {
    super(customer.getArrivalTime());
    this.bank = bank;
    this.customer = customer;
  }

  /**
   * Simulate method determine which one events the customer should have
   * - Join the bank queue
   * - Join the bank counter queue
   * - Go straight to the bank counter and begin service
   *
   * @return Events
   */
  @Override
  public Event[] simulate() {
    BankCounter counter = this.bank.getAvailableCounter();
    BankCounter counterToWait = this.bank.findCounter();
    boolean joinBankQueue = (counter == null) && (counterToWait == null);
    
    if (joinBankQueue && !(this.bank.queueIsFull())) {
      return new Event[] {
        new JoinQueue(this.customer, this.bank, this.getTime())
      };
    }

    if (joinBankQueue && this.bank.queueIsFull()) {
      return new Event[] {
        new Departure(this.getTime(), this.customer)
      };
    }

    if (counter == null && !(counterToWait.queueIsFull())) {
      return new Event[] { 
        new JoinCounterQueue(this.customer, counterToWait, this.customer.getArrivalTime()) 
      };
    }

    return new Event[] {
      new ServiceBegin(this.customer, counter, this.getTime(), this.bank)
    };
  }

  @Override
  public String toString() {
    return super.toString()
            + String.format(": %s arrived %s", this.customer, this.bank.printQueue());
  }
}
