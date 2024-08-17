package com.ka.parametros;
public class Parametros implements Runnable {
    private final int threadNumber;

    public Parametros(int number) {
        this.threadNumber = number;
    }

    @Override
    public void run() {
        System.out.println("Hilo " + threadNumber + " ejecutado con ID: " + Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Parametros(i));
            thread.start();
        }
    }
}
