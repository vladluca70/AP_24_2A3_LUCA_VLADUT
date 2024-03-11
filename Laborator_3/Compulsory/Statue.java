public class Statue extends Attraction implements Visitable
{
    private String openingHours;

    public Statue(String name)
    {
        super(name);
    }

    @Override
    public void setOpeningHours(String openingHours)
    {
        this.openingHours = openingHours;
    }
}
