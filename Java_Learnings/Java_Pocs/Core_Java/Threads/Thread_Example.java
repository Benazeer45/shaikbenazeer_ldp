package Core_Java.Threads;

class MyThreadNew extends Thread {
    private String threadName;

    public MyThreadNew(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        System.out.println(threadName + " is starting.");

        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " is working: " + i);
            try {
                Thread.sleep(500); // Simulating work
            } catch (InterruptedException e) {
                System.out.println(threadName + " was interrupted.");
            }
        }

        System.out.println(threadName + " is finishing.");
    }
}

public class Thread_Example {
    public static void main(String[] args) {
        MyThreadNew thread1 = new MyThreadNew("Thread 1");
        MyThreadNew thread2 = new MyThreadNew("Thread 2");

        thread1.start(); // Start the first thread
        thread2.start(); // Start the second thread

        // Wait for threads to finish
        try {
            thread1.join(); // Wait for thread1 to finish
            thread2.join(); // Wait for thread2 to finish
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        System.out.println("Both threads have finished.");
    }
}
