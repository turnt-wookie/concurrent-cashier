package com.rejonpardenilla.Models;

public class Product extends Thread {
    private int identificationNumber;
    private float price;
    private int processingSeconds;

    public Product(int id, float price, int processingSeconds) {
        this.identificationNumber = id;
        this.price = price;
        this.processingSeconds = processingSeconds;
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
        return "Procesando el producto #" + identificationNumber + ", espere " + processingSeconds + " segundos...";
    }

    @Override
    public synchronized void start() {
        System.out.println(this.toString());
        super.start();
    }
}
