package com.ka.tema3;
public class Thread extends Thread {
    public void run() {
        System.out.println("Hilo ejecutado usando la clase Thread. ID: " + Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        Threads thread1 = new Threads();
        Threads thread2 = new Threads();
        
        thread1.start();
        thread2.start();
    }
}
