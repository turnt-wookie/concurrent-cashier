
import model.*;
import syncronized.Bank;
import syncronized.ClientQueue;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList<Client> clients = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();

        products.add(null);
        products.add(new Product(1, 12, 2));
        products.add(new Product(2, 12, 4));
        products.add(new Product(3, 12, 6));
        products.add(new Product(4, 12, 1));
        products.add(new Product(5, 12, 3));
        products.add(new Product(6, 12, 5));

        Boolean isUserInputClients = true;
        int clientId = 1;
        Scanner stringScanner = new Scanner(System.in);
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
                System.out.println("Introduzca el id del producto #" + productId + " para el cliente #" + clientId);
                int clientProductId = intScanner.nextInt();
                currentClient.addProducts(products.get(clientProductId));
                productId++;

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

        System.out.println("\n\n\n\n");
        System.out.println("Poniendo cajeros en cola...");
        System.out.println("\n");

        // Create the shared elements
        Bank bank = new Bank(500);
        ClientQueue clientQueue = new ClientQueue(clients);

        // Set the shared elements to the cashiers
        Cashier cashier1 = new Cashier(1, bank, clientQueue);
        Cashier cashier2 = new Cashier(2, bank, clientQueue);
        Cashier cashier3 = new Cashier(3, bank, clientQueue);
        Cashier cashier4 = new Cashier(4, bank, clientQueue);

        // The cashiers will start to attend to the available clients
        cashier1.start();
        cashier2.start();
        cashier3.start();
        cashier4.start();
    }

}
