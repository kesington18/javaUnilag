import java.util.concurrent.*;
import java.util.concurrent.locks.*;


public class AccountWithoutSync {
    private static final Account account = new Account();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool(); // create executor

        // create and launch 100 threads
        for(int i = 0; i < 100; i++) {
            executor.execute(new AddAPennyTask());
        }

        executor.shutdown();

//        wait untill all tasked are finished
        while(!executor.isTerminated()) { //wait for all tasks to terminate
        }

        System.out.println("What is balance? " + account.getBalance());
    }

    // A thread for adding a penny to the account
    private static class AddAPennyTask implements Runnable {
        public void run() {
            synchronized (account) {
                account.deposit(1);
            }
        }
    }

//    an inner class for account
    private static class Account {
        private static Lock lock = new ReentrantLock(); // Create a lock
        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        public synchronized void deposit(int amount) {
            lock.lock(); // Acquire the lock
            int newBalance = balance + amount;

            try{
            // This delay is deliberately added to magnify the
            // data-corruption problem and make it easy to see.
                Thread.sleep(5);
            } catch (InterruptedException ex) {
            } finally {
                lock.unlock(); // Release the lock
            }

            balance = newBalance;
        }
    }
}
