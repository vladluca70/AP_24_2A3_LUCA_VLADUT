import javax.swing.*;
import java.util.*;

public class Problem {
    private List<Depot> depots;
    private List<Vehicle> vehicles;
    private List<Client> clients;

    public Problem() {
        this.depots = new ArrayList<>();
        this.vehicles = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    //daca primim un obiect de tipul depot, mai intai verificam daca deja exista in lista
    //daca nu exista in lista, il vom adauga
    public void addDepot(Depot depot) {
        if (!depots.contains(depot)) {
            depots.add(depot);
        }
    }

    //daca primim un obiect de tipul vehicle, mai intai verificam daca deja exista in lista
    //daca nu exista in lista, il vom adauga
    public void addVehicle(Vehicle vehicle) {
        if (!vehicles.contains(vehicle)) {
            vehicles.add(vehicle);
        }
    }

    //daca primim un obiect de tipul client, mai intai verificam daca deja exista in lista
    //daca nu exista in lista, il vom adauga
    public void addClient(Client client) {
        if (!clients.contains(client)) {
            clients.add(client);
        }
    }

    public List<Depot> getDepots() {
        return depots;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public List<Client> getClients() {
        return clients;
    }

}
