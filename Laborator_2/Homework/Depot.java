import  java.util.*;
public class Depot {
    private String name;

    public Depot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Depot{name='" + name + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Depot otherDepot = (Depot) o;
        return Objects.equals(name, otherDepot.name);
    }
}


