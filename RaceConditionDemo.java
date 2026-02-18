public class RaceConditionDemo {

    // Shared resource
    static class Counter {
        int count = 0;

        public synchronized void increment() {  // remove the synchronized to see the output which is sometimes 1500 or so
            count++; // NOT thread safe
        }
    }

    // Task that each thread will run
    static class MyTask implements Runnable {
        private Counter counter;

        public MyTask(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        Thread t1 = new Thread(new MyTask(counter));
        Thread t2 = new Thread(new MyTask(counter));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count: " + counter.count);
    }
}
