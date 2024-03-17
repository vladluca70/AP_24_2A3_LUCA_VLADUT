import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*instanta a clasei Statue*/
        Statue statue = new Statue("Statue_1");
        statue.setOpeningHours("8am- 8pm");

        /*instanta a clasei Church*/
        Church church = new Church("Church1");
        church.setOpeningHours("6am- 10pm");
        church.setEntryFee(10.00);

        /*instanta a clasei Concert*/
        Concert concert = new Concert("Concert1");
        concert.setOpeningHours("Duminica 4pm");
        concert.setEntryFee(7.50);

        /*facem o mapare dintre data si orele de deschidere si inchidere*/
        Map<String, Pair<LocalTime, LocalTime>> visitingTimetable = new HashMap<>();
        visitingTimetable.put("2024-03-16", new Pair<>(LocalTime.of(8, 0), LocalTime.of(20, 0)));
        visitingTimetable.put("2024-03-17", new Pair<>(LocalTime.of(6, 0), LocalTime.of(22, 0)));
        visitingTimetable.put("2024-03-18", new Pair<>(LocalTime.of(16, 0), LocalTime.of(23, 59)));

        /*facem o lista in care adaugam atractiile
        * aceasta lista va fi transmisa ca parametru*/
        List<Attraction> attractions = new ArrayList<>();
        attractions.add(statue);
        attractions.add(church);
        attractions.add(concert);

        Trip trip = new Trip("City1", "10am- 10pm", attractions, visitingTimetable);

        System.out.println("Oras " + trip.getCityName() + ", durata " + trip.getPeriodOfTime());
        System.out.println("Atractii");
        for (Attraction attraction : trip.getAttractions())
            System.out.println("- " + attraction.getName());

        System.out.println("\nVisitable Locations (Not Payable):");
        trip.displayVisitableLocationsNotPayable("2024-03-16");
    }
}

/*clasa Pair care face pereche intre ora de deschidere si ora de inchidere*/
class Pair<T, U> {
    public T time1;
    public U time2;

    public Pair(T time1, U time2) {
        this.time1 = time1;
        this.time2 = time2;
    }
}
