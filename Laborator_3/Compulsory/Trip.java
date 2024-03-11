import java.util.*;
public class Trip
{
    private String cityName;
    private String periodOfTime;
    private List<Attraction> attractions;

    public Trip(String cityName, String periodOfTime, List<Attraction> attractions)
    {
        this.cityName = cityName;
        this.periodOfTime = periodOfTime;
        this.attractions = attractions;
    }

    public String getCityName()
    {
        return cityName;
    }

    public String getPeriodOfTime()
    {
        return periodOfTime;
    }

    public List<Attraction> getAttractions()
    {
        return attractions;
    }
}
