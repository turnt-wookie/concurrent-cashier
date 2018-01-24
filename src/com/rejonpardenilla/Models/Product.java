package com.rejonpardenilla.Models;

import com.rejonpardenilla.Main;

public class Product extends Thread {
    private final int numberOfClient;
    private int identificationNumber;
    private float price;
    private int processingSeconds;
    private Main.AfterPayCallback callback;

    public Product(int numberOfClient, int id, float price, int processingSeconds) {
        this.identificationNumber = id;
        this.price = price;
        this.processingSeconds = processingSeconds;
        this.numberOfClient = numberOfClient;
    }

    public int getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(int id) {
        this.identificationNumber = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getProcessingSeconds() {
        return processingSeconds;
    }

    public void setProcessingSeconds(int processingSeconds) {
        this.processingSeconds = processingSeconds;
    }

    @Override
    public String toString() {
        return  "Procesando producto #" + identificationNumber +
                " del cliente #" + numberOfClient +
                "con tiempo " + processingSeconds + " por el cajero";
    }

    @Override
    public void run() {
        super.run();
        try {
            sleep(processingSeconds*10);
            System.out.println(this.toString());
            if (callback != null) {
                callback.done(this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Interrupted");
        }
    }

    public void start(Main.AfterPayCallback callback) {
        this.callback = callback;
        start();
    }
}
