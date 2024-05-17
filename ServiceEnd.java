/**
 * This class implements the end of service process
 *
 * @author QIU JINHANG
 * @version CS2030S AY23/24 Semester 2
 */
public class ServiceEnd extends Event {
  private Customer customer;
  private BankCounter bankCounter;
  private Bank bank;

  public ServiceEnd(Customer customer, BankCounter bankCounter, double endTime, Bank bank) {
    super(endTime);
    this.customer = customer;
    this.bankCounter = bankCounter;
    this.bank = bank;
  }

  @Override
  public String toString() {
    return super.toString() +
           String.format(": %s ", this.customer) +
           this.customer.printTask() +
           " done " + "(" + 
           String.format("by %s", this.bankCounter) +
           ")" + String.format(" %s", this.bankCounter.getServiceStatus());
  }

  @Override
  public Event[] simulate() {
    this.bankCounter.makeAvailable();
    
    if (this.bankCounter.queueIsEmpty() && this.bank.queueIsEmpty()) {
      return new Event[] {
        new Departure(this.getTime(), this.customer)
      };
    }
 
    if (this.bankCounter.queueIsEmpty() && !this.bank.queueIsEmpty()) {
      Customer nextCustomer = this.bank.switchQueue();
      return new Event[]{
        new Departure(this.getTime(), this.customer),
        new ServiceBegin(nextCustomer, this.bankCounter, this.getTime(), this.bank)
      };
    }

    Customer nextCustomer = this.bankCounter.nextCustomer();

    if (this.bank.queueIsEmpty()) {
      return new Event[]{ 
        new Departure(this.getTime(), this.customer),
        new ServiceBegin(nextCustomer, this.bankCounter, this.getTime(), this.bank)
      };
    }

    Customer welcomeToBank = this.bank.switchQueue();
    double joinCounterQueueTime = this.getTime() + 0.01;
    return new Event[] {
      new Departure(this.getTime(), this.customer),
      new ServiceBegin(nextCustomer, this.bankCounter, this.getTime(), this.bank),
      new JoinCounterQueue(welcomeToBank, bankCounter, joinCounterQueueTime)
    };
  }
}

