public class Church extends Attraction implements Visitable, Payable
{
    private String openingHours;
    private double entryFee;

    public Church(String name) {
        super(name);
    }

    @Override
    public void setOpeningHours(String openingHours)
    {
        this.openingHours = openingHours;
    }

    @Override
    public void setEntryFee(double entryFee)
    {
        this.entryFee = entryFee;
    }
}
