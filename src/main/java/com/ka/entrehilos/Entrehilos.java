package com.ka.entrehilos;
public class Entrehilos {
    private final Object lock = new Object();
    private boolean ready = false;
    public void producer() throws InterruptedException {
        synchronized (lock) {
            while (ready) {
                lock.wait();}
            System.out.println("Carga");
            ready = true;
            lock.notify();
        }}
    public void consumer() throws InterruptedException {synchronized (lock) { while (!ready) { lock.wait();}
            System.out.println("Finalizacion");
            ready = false;
            lock.notify();
        }}
    public static void main(String[] args) throws InterruptedException {
    	Entrehilos entrehilos = new Entrehilos();
        Thread producerThread = new Thread(() -> {
            try {entrehilos.producer();
            } catch (InterruptedException e) {e.printStackTrace();
            }});
        Thread consumerThread = new Thread(() -> {
            try { entrehilos.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }});
        producerThread.start();
        consumerThread.start();
        producerThread.join();
        consumerThread.join();
    }}
