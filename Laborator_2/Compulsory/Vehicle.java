public class Vehicle {
    private String vehicleNumber;
    private Depot depot;

    public Vehicle(String vehicleNumber, Depot depot) {
        this.vehicleNumber = vehicleNumber;
        this.depot = depot;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Depot getDepot() {
        return depot;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    @Override
    public String toString() {
        return "Vehicle{vehicleNumber='" + vehicleNumber + "', depot=" + depot + "}";
    }
}
