package bank4;

public class Main {

    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        for (int i = 1; i <= 10; i++) {
            DepositRunnable dThread = new DepositRunnable(account, i);
            WithdrawRunnable wThread = new WithdrawRunnable(account, i);
            dThread.run();
            wThread.run();
        }
    }
}