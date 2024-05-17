/**
 * This class implements a service in a bank counter
 *
 * @author QIU JINHANG
 * @version CS2030S AY23/24 Semester 2
 */
public class ServiceBegin extends Event {
  private Customer customer;
  private BankCounter bankCounter;
  private Bank bank;

  public ServiceBegin(Customer customer, BankCounter bankCounter, double time, Bank bank) {
    super(time);
    this.customer = customer;
    this.bankCounter = bankCounter;
    this.bank = bank;
  }

  @Override
  public String toString() {
    return super.toString() +
           String.format(": %s ", this.customer) +
           this.customer.printTask() +
           " begin " + "(" + 
           String.format("by %s", this.bankCounter) + ")";
  }

  @Override
  public Event[] simulate() {
    this.bankCounter.makeBusy();
    this.customer.getServicing(this.bankCounter); 
    double endTime = this.getTime() + this.customer.getServiceTime();
    return new Event[] { new ServiceEnd(this.customer, this.bankCounter, endTime, this.bank) };
  }
}
