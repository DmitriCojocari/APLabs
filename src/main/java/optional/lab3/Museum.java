package optional.lab3;

import java.time.LocalTime;

public class Museum extends Location implements Visitable, Payable {

    private double entryFee;
    private LocalTime openingTime, closingTime;

    public Museum(String locationName, String locationDescription, String locationCoordinates, double entryFee) {
        super(locationName, locationDescription, locationCoordinates);
        this.entryFee = entryFee;
    }

    @Override
    public double getEntryFee() {
        return entryFee;
    }

    @Override
    public String toString() {
        return "\n Museum { " +
                "MuseumName = " + getLocationName() +
                ", openingHour = " + getStartHour() +
                ", closingHour = " + getFinishHour() +
                '}';
    }

    @Override
    public LocalTime getStartHour() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    @Override
    public LocalTime getFinishHour() {
        return closingTime;


    }
}
