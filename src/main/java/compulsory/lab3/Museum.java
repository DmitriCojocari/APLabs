package compulsory.lab3;

import java.time.LocalTime;

public class Museum extends Location implements Visitable, Payable {
    private double entryFee;

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
                ", entryFee = " + getEntryFee() +
                ", openingHour = " + getStartHour() +
                ", closingHour = " + getFinishHour() +
                '}';
    }

    @Override
    public LocalTime getStartHour() {
        return LocalTime.parse("09:00");
    }

    @Override
    public LocalTime getFinishHour() {
        return LocalTime.parse("16:00");
    }
}
