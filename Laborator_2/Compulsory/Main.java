public class Main {
    public static void main(String[] args) {
        Depot depot = new Depot("Depot1");
        Vehicle vehicle = new Vehicle("Dacia", depot);

        Client regularClient = new Client("Ion", "9:00", "12:00", ClientType.REGULAR);
        Client premiumClient = new Client("Vasile", "13:30", "17:45", ClientType.PREMIUM);

        System.out.println(depot);
        System.out.println(vehicle);
        System.out.println(regularClient);
        System.out.println(premiumClient);
    }
}