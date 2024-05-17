public class Withdraw extends Task {
  public Withdraw(int flow) {
    super(flow);
  }

  @Override
  public void conductService(BankCounter bankCounter) {
    bankCounter.withdraw(super.getFlow());
  }

  @Override
  public String toString() {
    return String.format("withdrawal $%s", super.getFlow());
  }
}
