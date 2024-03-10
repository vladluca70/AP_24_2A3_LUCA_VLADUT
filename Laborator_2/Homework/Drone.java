import java.util.*;

public class Drone extends  Vehicle{
    private int flightDuration;

    public Drone(String vehicleNumber, Depot depot, int flightTime) {
        super(vehicleNumber, depot);
        this.flightDuration = flightTime;
    }

    public int getFlightTime() {
        return flightDuration;
    }

    public void setFlightTime(int flightTime) {
        this.flightDuration = flightTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Drone drone = (Drone) o;
        return flightDuration == drone.flightDuration;
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightDuration);
    }
}
