package bank4;

public class WithdrawRunnable extends BankTransaction implements Runnable {

    private final int amountToWithdraw;

    public WithdrawRunnable(BankAccount account, int amountToWithdraw) {
        super(account);
        this.amountToWithdraw = amountToWithdraw;
    }

    @Override
    public void run() {
        wasteTime();
        account.withdraw(amountToWithdraw);
    }
}
