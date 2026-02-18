//public class TaskThreadDemo {
//    public static void main(String[] args) {
//         // Create tasks
//         Runnable printA = new PrintChar('a', 100);
//         Runnable printB = new PrintChar('b', 100);
//         Runnable print100 = new PrintNum(100);
//
//         // Create threads
//         Thread thread1 = new Thread(printA);
//         Thread thread2 = new Thread(printB);
//         Thread thread3 = new Thread(print100);
//
//         // Start threads
//         thread1.start();
//         thread2.start();
////         thread3.start();
//         thread3.setPriority(Thread.MAX_PRIORITY);
//    }
//}
//
//class PrintChar implements Runnable {
//    private char charToPrint; // The character to print
//    private int times; // The number of times to repeat
//
//    /**
//     * Construct a task with a specified character and number of
//     * times to print the character
//     */
//    public PrintChar(char c, int t) {
//        charToPrint = c;
//        times = t;
//    }
//
//    @Override
//    /** Override the run() method to tell the system
//     34 * what task to perform
//     35 */
//    public void run() {
//        for (int i = 0; i < times; i++) {
//            System.out.print(charToPrint);
//        }
//    }
////    public void run() {
////        try {
////            System.out.println("I am going to sleep for 1 second...");
////            Thread.sleep(1000); // Sleep for 1000 milliseconds (1 second)
////            System.out.println("I woke up!");
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
////    }
//}
//
//// The task class for printing numbers from 1 to n for a given n
//class PrintNum implements Runnable {
//    private int lastNum;
//
//         /** Construct a task for printing 1, 2, ..., n */
//    public PrintNum(int n) {
//        lastNum = n;
//    }
//    @Override /** Tell the thread how to run */
//     public void run() {
//             for (int i = 1; i <= lastNum; i++) {
//                 System.out.print(" " + i);
////                 Thread.yield();
//             }
//     }
//
////        public void run() {
////            try {
////                for (int i = 1; i <= lastNum; i++) {
////                    System.out.print(" " + i);
////                    if (i >= 50) Thread.sleep(1);
////                }
////            }
////            catch (InterruptedException ex) {
////            }
////        }
////        public void run() {
////            Thread thread4 = new Thread(
////                    new PrintChar('c', 40));
////            thread4.start();
////            try {
////                for (int i = 1; i <= lastNum; i++) {
////                    System.out.print (" " + i);
////                    if (i == 50) thread4.join();
////                }
////            }
////            catch (InterruptedException ex) {
////            }
////        }
//}