package com.rejonpardenilla;

import com.rejonpardenilla.Models.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Client> clients = new ArrayList<>();
        Boolean isUserInputClients = true;
        int clientId = 1;
        Scanner stringScanner = new Scanner(System.in);
        Scanner floatScanner = new Scanner(System.in);
        Scanner intScanner = new Scanner(System.in);

        System.out.println("~ .:: | BIENVENIDO | ::. ~");
        System.out.println("\n\n");

        // Clients loop
        while (isUserInputClients) {
            Client currentClient = new Client(clientId);
            System.out.println("Introduzca los productos del Cliente #" + clientId);

            Boolean isUserInputProducts = true;
            int productId = 1;
            // Products loop
            while (isUserInputProducts) {
                System.out.println("Introduzca el precio del producto #" + productId);
                float price = floatScanner.nextFloat();
                System.out.println("Introduzca el tiempo de procesamiento del producto #" + productId);
                int processingSeconds = intScanner.nextInt();

                Product currentProduct = new Product(productId, price, processingSeconds);
                productId++;
                currentClient.addProducts(currentProduct);

                // End product loop?
                System.out.println("¿Desea introducir otro producto? (y/n)");
                String productResponse = stringScanner.nextLine();
                isUserInputProducts = (productResponse.equals("y") || productResponse.equals("Y"));
            }

            clients.add(currentClient);
            clientId++;

            // End client loop?
            System.out.println("¿Desea introducir otro cliente? (y/n)");
            String clientResponse = stringScanner.nextLine();
            isUserInputClients = (clientResponse.equals("y") || clientResponse.equals("Y"));
        }

        // Process all client products
        System.out.println("Procesando todos los productos de los clientes...");
        for (Client client : clients) {
            System.out.println("Cliente #" + client.getId());
            ArrayList<Product> products = client.getProducts();
            for (Product product : products) {
                product.start();
                Thread.sleep(product.getProcessingSeconds() * 1000);
            }
        }

        System.out.println("\n\n\n");
        System.out.println("¡Todos los productos han sido procesados!");
    }
}
