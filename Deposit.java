public class Deposit extends Task {

  public Deposit(int flow) {
    super(flow);
  }
 
  @Override
  public void conductService(BankCounter bankCounter) {
    bankCounter.deposit(super.getFlow());
  }

  @Override
  public String toString() {
    return String.format("deposit $%s", super.getFlow());
  }

}
