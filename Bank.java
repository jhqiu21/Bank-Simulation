/**
 * This class implements a bank
 *
 * @author QIU JINHANG
 * @version CS2030S AY23/24 Semester 2
 */
public class Bank {
  private Seq<BankCounter> counters;
  private Queue<Customer> bankQueue;
  private final int numOfCounters;

  public Bank(int numOfCounters, int counterQueueLength, int bankQueueSize) {
    this.bankQueue = new Queue<>(bankQueueSize);
    this.numOfCounters = numOfCounters;
    this.counters = new Seq<>(numOfCounters);
    for (int i = 0; i < numOfCounters; i++) {
      this.counters.set(i, new BankCounter(counterQueueLength));
    }
  }

  /**
   * Find an available bank counter in the bank
   * @return BankCounter
   */
  public BankCounter getAvailableCounter() {
    for (int i = 0; i < this.numOfCounters; i++) {
      if (this.counters.get(i).isAvailable()) {
        return this.counters.get(i);
      }
    }
    return null;
  }

  /**
   * Find a bank counter for a customer, if all
   * bank counter queue is full, the customer need
   * to join the bank queue until there is a bank
   * counter can be allocated.
   * @return BankCounter
   */
  public BankCounter findCounter() { 
    if (this.counters.min().queueIsFull()) {
      return null;
    } 
    return this.counters.min();
  }

  /**
   * Customer join the bank queue when all counter
   * queue is full
   * @return boolean
   */
  public boolean joinQueue(Customer customer) {
    return this.bankQueue.enq(customer);
  }

  /**
   * Customer in the bank queue "come in" the bank
   * and join the counter queue he/she was allocated
   * @return Customer
   */
  public Customer switchQueue() {
    return this.bankQueue.deq();
  }

  public boolean queueIsFull() {
    return this.bankQueue.isFull();
  }

  public boolean queueIsEmpty() {
    return this.bankQueue.isEmpty();
  }

  /**
   * Queue of this bank
   * @return Queue of this bank
   */
  public String printQueue() {
    return this.bankQueue.toString();
  }
}
