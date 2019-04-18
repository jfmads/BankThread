package bank4;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Will store the reference to a bank account. 
 * @author Joseph Madden
 */
public class BankTransaction {
    protected BankAccount account;
    
    public BankTransaction(BankAccount account){
        this.account = account;
    }

    protected void wasteTime() {
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        try {
            Thread.sleep(rand.nextInt(1000));
        } catch (InterruptedException ex) {
        }
    }    
}
