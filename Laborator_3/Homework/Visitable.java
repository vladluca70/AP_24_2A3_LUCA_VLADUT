import java.time.LocalTime;

interface Visitable {
    void setOpeningHours(String openingHours);

    default LocalTime getOpeningHourForDate(String date) {
        return null;
    }
}
