package compulsory.lab3;

import java.util.Map;

public class Location implements Comparable<Location> {
    private String locationName;
    private String locationDescription;
    private String locationCoordinates;

    private Map<Location, Integer> requiredTimes;

    public Location(String locationName, String locationDescription, String locationCoordinates) {
        this.locationName = locationName;
        this.locationDescription = locationDescription;
        this.locationCoordinates = locationCoordinates;
    }

    @Override
    public int compareTo(Location location) {
        int compareValue = this.locationName.compareTo(location.locationName);
        return compareValue;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public String getLocationCoordinates() {
        return locationCoordinates;
    }

    public void setLocationCoordinates(String locationCoordinates) {
        this.locationCoordinates = locationCoordinates;
    }

    public Map<Location, Integer> getRequiredTimes() {
        return requiredTimes;
    }

    public void setRequiredTimes(Map<Location, Integer> requiredTimes) {
        this.requiredTimes = requiredTimes;
    }

    @Override
    public String toString() {
        return "Location { \n" +
                "locationName='" + locationName + '\'' +
                ", locationDescription='" + locationDescription + '\n' +
                ", locationCoordinates='" + locationCoordinates + '\n' +
                '}';
    }
}
