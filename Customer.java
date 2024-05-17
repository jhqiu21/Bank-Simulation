/**
 * This class implements a customer in the bank
 *
 * @author QIU JINHANG
 * @version CS2030S AY23/24 Semester 2
 */
public class Customer {
  private final int id;
  private static int idCounter = 0;
  private int service;
  private final double serviceTime;
  private final double arrivalTime;
  private Task task;

  public Customer(double arrivalTime, double serviceTime, Task task) {
    this.id = idCounter++;
    this.service = service;
    this.arrivalTime = arrivalTime;
    this.serviceTime = serviceTime;
    this.task = task;
  }
  
  @Override
  public String toString() {
    return String.format("C%s", this.id);
  }

  public double getArrivalTime() {
    return this.arrivalTime;
  }

  public double getServiceTime() {
    return this.serviceTime;
  }

  public String printTask() {
    return this.task.toString();
  }

  public void getServicing(BankCounter bankCounter) {
    this.task.conductService(bankCounter);
  }
}
