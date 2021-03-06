package com.rejonpardenilla.Models;

import java.util.ArrayList;
import java.util.Arrays;

public class Client {
    private ArrayList<Product> products;
    private int id;

    public Client(int id) {
        this.id = id;
        this.products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProducts(Product...products) {
        this.products.addAll(Arrays.asList(products));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
