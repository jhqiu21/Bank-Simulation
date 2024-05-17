import java.util.Scanner;

/**
 * This class implements a bank simulation.
 *
 * @author Wei Tsang
 * @version CS2030S AY23/24 Semester 2
 */ 
class BankSimulation extends Simulation {
  /** 
   * The list of customer arrival events to populate
   * the simulation with.
   */
  public Event[] initEvents;

  /** 
   * Constructor for a bank simulation. 
   *
   * @param sc A scanner to read the parameters from.  The first
   *           integer scanned is the number of customers; followed
   *           by the number of service counters.  Next is a 
   *           sequence of (arrival time, service time) pair, each
   *           pair represents a customer.
   */
  public BankSimulation(Scanner sc) {
    this.initEvents = new Event[sc.nextInt()];
    Bank bank = new Bank(sc.nextInt(), sc.nextInt(), sc.nextInt());
    int id = 0;
    while (sc.hasNextDouble()) {
      double arrivalTime = sc.nextDouble();
      double serviceTime = sc.nextDouble();
      int service = sc.nextInt();
      if (service == 0) {
        int flow = sc.nextInt();
        Deposit deposit = new Deposit(flow);
        Customer customer = new Customer(arrivalTime, serviceTime, deposit);
        initEvents[id] = new Arrival(bank, customer);
      }
      if (service == 1) {
        int flow = sc.nextInt();
        Withdraw withdraw = new Withdraw(flow);
        Customer customer = new Customer(arrivalTime, serviceTime, withdraw);
        initEvents[id] = new Arrival(bank, customer);
      }
      id++;
    }
  }

  /**
   * Retrieve an array of events to populate the 
   * simulator with.
   *
   * @return An array of events for the simulator.
   */
  @Override
  public Event[] getInitialEvents() {
    return initEvents;
  }
}
