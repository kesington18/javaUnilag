import java.util.concurrent.*;

public class ExecutablePoolDemo {
    public static void main(String[] args) {
        // Create a pool with only 2 workers
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit 3 tasks. The first 2 run immediately.
        // The 3rd waits until one worker is free.
        executor.execute(new PrintChar('A', 100));
        executor.execute(new PrintChar('B', 100));
        executor.execute(new PrintChar('C', 100));
        executor.execute(new PrintChar('D', 100));
        executor.execute(new PrintNum( 100));

        // Close the pool when done
        executor.shutdown();
    }
}

class PrintChar implements Runnable {
    private char charToPrint; // The character to print
    private int times; // The number of times to repeat

    /**
     * Construct a task with a specified character and number of
     * times to print the character
     */
    public PrintChar(char c, int t) {
        charToPrint = c;
        times = t;
    }

    @Override
    /** Override the run() method to tell the system
     34 * what task to perform
     35 */
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.print(charToPrint);
        }
    }
//    public void run() {
//        try {
//            System.out.println("I am going to sleep for 1 second...");
//            Thread.sleep(1000); // Sleep for 1000 milliseconds (1 second)
//            System.out.println("I woke up!");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}

// The task class for printing numbers from 1 to n for a given n
class PrintNum implements Runnable {
    private int lastNum;

    /** Construct a task for printing 1, 2, ..., n */
    public PrintNum(int n) {
        lastNum = n;
    }
    @Override /** Tell the thread how to run */
    public void run() {
        for (int i = 1; i <= lastNum; i++) {
            System.out.print(" " + i);
//                 Thread.yield();
        }
    }

//        public void run() {
//            try {
//                for (int i = 1; i <= lastNum; i++) {
//                    System.out.print(" " + i);
//                    if (i >= 50) Thread.sleep(1);
//                }
//            }
//            catch (InterruptedException ex) {
//            }
//        }
//        public void run() {
//            Thread thread4 = new Thread(
//                    new PrintChar('c', 40));
//            thread4.start();
//            try {
//                for (int i = 1; i <= lastNum; i++) {
//                    System.out.print (" " + i);
//                    if (i == 50) thread4.join();
//                }
//            }
//            catch (InterruptedException ex) {
//            }
//        }
}