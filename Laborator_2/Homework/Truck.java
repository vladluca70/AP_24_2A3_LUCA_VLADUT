import java.util.*;

public class Truck extends Vehicle{
    private int capacity;

    Truck(String vehicleNumber, Depot depot, int capacity)
    {
        super(vehicleNumber, depot);
        this.capacity=capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Truck truck = (Truck) o;
        return capacity == truck.capacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(capacity);
    }
}
