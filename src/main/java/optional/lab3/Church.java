package optional.lab3;

import java.time.LocalTime;

public class Church extends Location implements Visitable {

    private LocalTime openingTime, closingTime;

    public Church(String locationName, String locationDescription, String locationCoordinates) {
        super(locationName, locationDescription, locationCoordinates);
    }

    @Override
    public LocalTime getStartHour() {
        return openingTime;
    }

    @Override
    public LocalTime getFinishHour() {
        return closingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    @Override
    public String toString() {
        return "\n Church { " + "ChurchName = " + getLocationName() + ", openingHour = " + getStartHour() +
                ", closingHour = " + getFinishHour() +
                '}' ;
    }
}
