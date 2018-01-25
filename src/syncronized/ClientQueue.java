package syncronized;

import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;

import model.Client;

public class ClientQueue {
    private ArrayList<Client> clientsInLine;

    public ClientQueue(ArrayList<model.Client> clientsInLine) {
        this.clientsInLine = clientsInLine;
    }

    public synchronized Client poll() {
        return clientsInLine.isEmpty() ? null : clientsInLine.remove(0);
    }

    public void add(Client client) {
        clientsInLine.add(client);
    }

    public boolean isEmpty() {
        return clientsInLine.isEmpty();
    }
}
