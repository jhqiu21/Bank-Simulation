/**
 * This class implements a bank counter
 *
 * @author QIU JINHANG
 * @version CS2030S AY23/24 Semester 2
 */
public class BankCounter implements Comparable<BankCounter> {
  private final int id;
  private static int count = 0;
  private int account = 100;
  private boolean available = true;
  private boolean status = true;
  private final Queue<Customer> counterQueue;

  public BankCounter(int size) {
    this.id = BankCounter.count++;
    this.counterQueue = new Queue<Customer>(size);
  }

  /**
   * Whether the bank counter is available now
   * @return available status
   */
  public boolean isAvailable() {
    return this.available;
  }

  /**
   * Make the counter available again after the
   * service end
   */
  public void makeAvailable() {
    this.available = true;
  }

  /**
   * Make the counter unavailable when the service
   * at this counter begin
   */
  public void makeBusy() {
    this.available = false;
  }

  /**
   * Next customer for this counter
   * @return Customer in the head of the queue
   */
  public Customer nextCustomer() {
    return this.counterQueue.deq();
  }

  /**
   * Make the customer join in the bank counter
   * queue before his/her turn
   * @param customer Customer joined this queue
   */
  public void joinCounterQueue(Customer customer) {
    this.counterQueue.enq(customer);
  }

  public boolean queueIsFull() {
    return this.counterQueue.isFull();
  }

  public boolean queueIsEmpty() {
    return this.counterQueue.isEmpty();
  }
  
  /**
   * Deposit service of this bank counter
   * @param money amount of money deposit into this account
   */
  public void deposit(int money) {
    this.account += money;
    this.status = true;
  }

  /**
   * Withdraw service of this bank counter
   * @param money amount of money withdraw from this account
   */
  public void withdraw(int money) { 
    if (money > this.account) {
      this.status = false;
    } else {
      this.account -= money;
      this.status = true;
    }
  }

  public String getServiceStatus() {
    return this.status ? "success" : "fail";
  }

  /**
   * Compare bank counter itself with other counter
   * based on availability and length of counter queue
   * @return int
   */
  @Override
  public int compareTo(BankCounter otherCounter) {

    if (this.available && otherCounter.isAvailable()) {
      return this.id < otherCounter.id ? -1 : 1;
    } else if (this.available) {
      return -1;
    } else if (otherCounter.isAvailable()) {
      return 1;
    }

    if (this.counterQueue.length() == otherCounter.counterQueue.length()) {
      return this.id < otherCounter.id ? -1 : 1;
    }

    if (this.counterQueue.length() < otherCounter.counterQueue.length()) {
      return -1;
    }

    if (this.counterQueue.length() > otherCounter.counterQueue.length()) {
      return 1;
    }

    return 0;
  }

  @Override
  public String toString() {
    return String.format("S%s $%s %s", this.id, this.account, this.counterQueue) ;
  }
}
