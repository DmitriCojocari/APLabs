package compulsory.lab3;

import java.time.LocalTime;

public class Church extends Location implements Visitable {

    public Church(String locationName, String locationDescription, String locationCoordinates) {
        super(locationName, locationDescription, locationCoordinates);
    }

    @Override
    public LocalTime getStartHour() {
        return LocalTime.parse("07:00");
    }

    @Override
    public LocalTime getFinishHour() {
        return LocalTime.parse("19:00");
    }

    @Override
    public String toString() {
        return "\n Church { " + "ChurchName = " + getLocationName() + ", openingHour = " + getStartHour() +
                ", closingHour = " + getFinishHour() + '}';
    }
}
