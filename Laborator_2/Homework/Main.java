import  java.util.*;

public class Main {
    public static void main(String[] args) {
        //in clasa problem vom adauga in liste separate fiecare depozit, client si vehicul
        Problem problem = new Problem();

        Depot depot = new Depot("Depot1");
        problem.addDepot(depot);

        Vehicle vehicle1 = new Vehicle("Dacia", depot);
        Vehicle vehicle2 = new Vehicle("Trabant", depot);
        Vehicle vehicle3 = new Vehicle("Mercedes", depot);
        Vehicle vehicle4 = new Vehicle("Limuzina", depot);

        problem.addVehicle(vehicle1);
        problem.addVehicle(vehicle2);
        problem.addVehicle(vehicle3);
        problem.addVehicle(vehicle4);

        Client regularClient = new Client("Ion", "9:00", "12:00", ClientType.REGULAR);
        Client premiumClient = new Client("Vasile", "13:30", "17:45", ClientType.PREMIUM);
        problem.addClient(regularClient);
        problem.addClient(premiumClient);

        Random random = new Random();

        //parcurgem lista de clienti in ordinea in care s-au inregistrat
        //pentru fiecare client vom asigna cate un vehicul in mod aleator
        for(Client x: problem.getClients())
        {
            //vom genera un numar random intre 0 si numarul de vehicule-1
            int length= problem.getVehicles().size();

            //generam random un vehicul
            int n=random.nextInt(length);

            //afisam clientul si vehiculul, dupa care stergem vehiculul respectiv din lista
            System.out.println(x);
            System.out.println(problem.getVehicles().get(n));
            System.out.println();
            problem.getVehicles().remove(n);
        }
    }
}


