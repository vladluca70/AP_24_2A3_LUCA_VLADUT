class Concert extends Attraction implements Visitable, Payable {
    /*variabile*/
    private String openingHours;
    private double entryFee;

    /*constructor*/
    public Concert(String name) {
        super(name);
    }

    /*rescriem metoda setOpeningHours din clasa Attraction*/
    @Override
    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    /*rescriem metoda setEntryFree din clasa Attraction*/
    @Override
    public void setEntryFee(double entryFee) {
        this.entryFee = entryFee;
    }
}