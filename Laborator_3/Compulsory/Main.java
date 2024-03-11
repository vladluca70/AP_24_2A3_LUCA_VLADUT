import java.util.*;

public class Main {
    public static void main(String[] args) {
        Statue statue = new Statue("Statue_1");
        statue.setOpeningHours("8am- 8pm");

        Church church = new Church("Church1");
        church.setOpeningHours("6am- 10pm");
        church.setEntryFee(10.00);

        Concert concert = new Concert("Concert1");
        concert.setOpeningHours("Duminica 4pm");
        concert.setEntryFee(7.50);

        List<Attraction> attractions = new ArrayList<>();
        attractions.add(statue);
        attractions.add(church);
        attractions.add(concert);


        Trip trip = new Trip("City1", "10am- 10pm", attractions);

        System.out.println("Oras " + trip.getCityName() + ", durata " + trip.getPeriodOfTime());
        System.out.println("Atractii");
        for (Attraction attraction : trip.getAttractions())
            System.out.println("- " + attraction.getName());
    }
}
