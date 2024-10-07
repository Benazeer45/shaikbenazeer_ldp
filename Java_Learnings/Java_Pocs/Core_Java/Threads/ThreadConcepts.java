package Core_Java.Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running.");
        try {
            Thread.sleep(1000); // Simulating work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " has completed.");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running (Runnable).");
        try {
            Thread.sleep(1000); // Simulating work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " has completed (Runnable).");
    }
}

class SharedResource {
    public synchronized void synchronizedMethod() {
        System.out.println(Thread.currentThread().getName() + " is in synchronized method.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " has exited synchronized method.");
    }
}

public class ThreadConcepts {

    public static void main(String[] args) {
        // Creating Threads by extending Thread class
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        thread1.start();
        thread2.start();

        // Creating Threads by implementing Runnable interface
        Thread runnableThread1 = new Thread(new MyRunnable());
        Thread runnableThread2 = new Thread(new MyRunnable());

        runnableThread1.start();
        runnableThread2.start();

        // Demonstrating synchronization
        SharedResource resource = new SharedResource();
        Thread syncThread1 = new Thread(() -> resource.synchronizedMethod());
        Thread syncThread2 = new Thread(() -> resource.synchronizedMethod());

        syncThread1.start();
        syncThread2.start();

        // Demonstrating thread priorities
        Thread priorityThread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " with priority: " + Thread.currentThread().getPriority());
        });
        priorityThread1.setPriority(Thread.MAX_PRIORITY);
        priorityThread1.start();

        Thread priorityThread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " with priority: " + Thread.currentThread().getPriority());
        });
        priorityThread2.setPriority(Thread.MIN_PRIORITY);
        priorityThread2.start();

        // Demonstrating ExecutorService
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new MyRunnable());
        executorService.submit(new MyRunnable());
        executorService.shutdown(); // Shutdown the executor service

        // Wait for threads to finish before exiting main
        try {
            thread1.join();
            thread2.join();
            runnableThread1.join();
            runnableThread2.join();
            syncThread1.join();
            syncThread2.join();
            priorityThread1.join();
            priorityThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads have completed.");
    }
}

