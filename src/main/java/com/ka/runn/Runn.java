package com.ka.runn;

public class Runn implements Runnable {
    @Override
    public void run() {
        System.out.println("Hilo usando la interfaz Runn. ID: " + Thread.currentThread().getID());
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runn());
        Thread thread2 = new Thread(new Runn());
        
        thread1.start();
        thread2.start();
    }
}
