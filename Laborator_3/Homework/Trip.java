import java.time.LocalTime;
import java.util.*;

class Trip {
    /*variabile*/
    private String cityName;
    private String periodOfTime;
    private List<Attraction> attractions;
    private Map<String, Pair<LocalTime, LocalTime>> visitingTimetable;

    /*constructor*/
    public Trip(String cityName, String periodOfTime, List<Attraction> attractions,
                Map<String, Pair<LocalTime, LocalTime>> visitingTimetable) {
        this.cityName = cityName;
        this.periodOfTime = periodOfTime;
        this.attractions = attractions;
        this.visitingTimetable = visitingTimetable;
    }

    /*encapsulare
    * getter method*/
    public String getCityName() {
        return cityName;
    }

    /*encapsulare
     * getter method*/
    public String getPeriodOfTime() {
        return periodOfTime;
    }

    /*encapsulare
     * getter method*/
    public List<Attraction> getAttractions() {
        return attractions;
    }

    /*functie pentru afisat atractiile vizitabile si gratis*/
    public void displayVisitableLocationsNotPayable(String date)
    {
        /*lista in care se vor memora atractiile vizitabile si gratis*/
        List<Visitable> visitableNotPayable = new ArrayList<>();
        for (Attraction attraction : attractions)
        {
            /*verificarea instantelor*/
            if (attraction instanceof Visitable && !(attraction instanceof Payable))
            {
                visitableNotPayable.add((Visitable) attraction);
            }
        }
        visitableNotPayable.sort(new Comparator<Visitable>()
        {
            @Override
            public int compare(Visitable a1, Visitable a2)
            {
                return getOpeningHourForDate(date).compareTo(getOpeningHourForDate(date));
            }
        });
        for (Visitable attraction : visitableNotPayable)
        {
            System.out.println("- " + ((Attraction)attraction).getName() + ": Opens at " + getOpeningHourForDate(date));
        }
    }

    public LocalTime getOpeningHourForDate(String date) {
        Pair<LocalTime, LocalTime> interval = visitingTimetable.get(date);
        if (interval != null) {
            return interval.time1;
        }
        return null;
    }
}