package optional.lab3;

import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Location implements Visitable, Comparable<Location> {

    private String locationName;
    private String locationDescription;
    private String locationCoordinates;
    private LocalTime openingTime, closingTime;
    private Map<Location, Integer> requiredTimes;
    private List<Location> shortestPath = new LinkedList<>();
    private Integer distance = Integer.MAX_VALUE;

    public Location(String locationName, String locationDescription, String locationCoordinates) {
        this.locationName = locationName;
        this.locationDescription = locationDescription;
        this.locationCoordinates = locationCoordinates;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public List<Location> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<Location> shortestPath) {
        this.shortestPath = shortestPath;
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
    public int compareTo(Location location) {
        int compareValue = this.getStartHour().compareTo(location.getStartHour());
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
        return "\n Location {" +
                "locationName='" + locationName + '\'' +
                ", openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                '}';
    }
}
