package bank4;

public class DepositRunnable extends BankTransaction implements Runnable {

    private final int amountToDeposit;

    public DepositRunnable(BankAccount account, int amountToDeposit) {
        super(account);
        this.amountToDeposit = amountToDeposit;
    }

    @Override
    public void run() {
        wasteTime();
        account.deposit(amountToDeposit);
    }
}