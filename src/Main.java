
import model.*;
import syncronized.Bank;
import syncronized.ClientQueue;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // TODO: scan this data by console
        ArrayList<Client> clients = new ArrayList<>();
        Product product1 = new Product(1, 12, 2);
        Product product2 = new Product(2, 12, 4);
        Product product3 = new Product(3, 12, 6);
        Client client1 = new Client(1);
        client1.addProducts(product1,product2,product3);

        Product product4 = new Product(4, 12, 1);
        Product product5 = new Product(5, 12, 3);
        Product product6 = new Product(6, 12, 5);
        Client client2 = new Client(2);
        client2.addProducts(product4,product5,product6);

        clients.add(client1);
        clients.add(client2);
        clients.add(client1);
        clients.add(client2);
        clients.add(client1);
        clients.add(client2);

        // Create the shared elements
        Bank bank = new Bank(500);
        ClientQueue clientQueue= new ClientQueue(clients);

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
