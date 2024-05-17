/**
 * This class is a general abstract class that
 * encapsulates a task. To implement a
 * task, inherit from this class and implement
 * the conductService method.
 *
 * @author QIU JINHANG
 * @version CS2030S AY23/24 Semester 2
 */

abstract class Task {
  private final int flow;
  public Task(int flow) {
    this.flow = flow;
  }
  
  public abstract void conductService(BankCounter bankCounter);

  public int getFlow() {
    return this.flow;
  }
}
