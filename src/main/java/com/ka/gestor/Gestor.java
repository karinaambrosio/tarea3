package com.ka.gestor;
public class Gestor {
    private int counter = 0;

    public Gestor void increment() {
        for (int i = 0; i < 1000; i++) {
            counter++;
        }
    }

    public static void main(String[] args) throws Gestor {
        Gestor counter = new Gestor();
        
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
