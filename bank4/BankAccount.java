package bank4;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private int balance;
    private final Lock lock = new ReentrantLock();
    private final Condition sufficientFundsCondition = lock.newCondition();

    public void deposit(int amount) {
        lock.lock();

        try {
            int newBalance = balance + amount;
            wasteTime();
            System.out.println(balance + " + " + amount + " = " + newBalance);
            wasteTime();
            balance = newBalance;
            sufficientFundsCondition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(int amount) {
        lock.lock();

        try {
            while (amount > balance) {
                sufficientFundsCondition.await();
            }

            int newBalance = balance - amount;
            wasteTime();
            System.out.println(balance + " - " + amount + " = " + newBalance);
            wasteTime();
            balance = newBalance;

        } catch (InterruptedException ex) {
            // squelch
        } finally {
            lock.unlock();
        }
    }

    public int getBalance() {
        return balance;
    }

    private void wasteTime() {
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        try {
            Thread.sleep(rand.nextInt(1000));
        } catch (InterruptedException ex) {
        }
    }
}
