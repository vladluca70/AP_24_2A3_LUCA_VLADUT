class Statue extends Attraction implements Visitable {
    /*variabila*/
    private String openingHours;

    /*constructor*/
    public Statue(String name) {
        super(name);
    }

    /*rescriem metoda setOpeningHours din clasa Attraction*/
    @Override
    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }
}