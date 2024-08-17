package com.ka.lock;
import java.util.concurrent.locks.ReentrantLock;
public class Lock {
    private int counter = 0;
    private final Lock lock = new ReentrantLock();
    public void increment() {
        lock.lock();
        try {
            for (int i = 0; i < 1000; i++) {
                counter++;
            }
        } finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Lock counter = new Lock);    
        Runnable task = counter::increment;
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("contador: " + counter.counter);
    }
}
