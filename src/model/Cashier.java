package model;

import syncronized.Bank;
import syncronized.ClientQueue;

import java.util.ArrayList;

public class Cashier extends Thread {
    private Bank sharedBank;
    private ClientQueue clientQueue;
    private Client currentClient;
    private int id;

    public Cashier(int id, Bank sharedBank, ClientQueue clientQueue) {
        this.sharedBank = sharedBank;
        this.clientQueue = clientQueue;
        this.id = id;
        currentClient = null;
    }

    @Override
    public void run() {
        super.run();
        attendClients();
    }

    private void attendClients() {
        // the charge to the clients asynchronously
        while (clientQueue != null && !clientQueue.isEmpty()) {
            currentClient = clientQueue.poll();
            float amountToCharge = 0;

            ArrayList<Product> products = currentClient.getProducts();

            for (Product product : products) {
                amountToCharge += makeCharge(product);
            }

            sharedBank.charge(amountToCharge);
        }
        System.out.println("Listo cashier " + this.id);
    }

    private float makeCharge(Product product) {
        StringBuilder phrase =
                new StringBuilder("procesando producto").append(product.getIdentificationNumber())
                .append(" de cliente").append(currentClient.getId())
                .append(" tiempo ").append(product.getProcessingSeconds())
                .append(" por el cajero ").append(this.id)
                .append(" con un costo de ").append(product.getPrice()).append(" pesos");
                ;

        try {
            sleep(product.getProcessingSeconds() * 100);
            System.out.println(phrase);
            return product.getPrice();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
