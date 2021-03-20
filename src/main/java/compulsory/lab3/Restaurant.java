package compulsory.lab3;

import java.time.LocalTime;

public class Restaurant extends Location implements Visitable, Payable, Classifiable {
    private double lunchPrice;
    private int rank;

    public Restaurant(String locationName, String locationDescription, String locationCoordinates, double lunchPrice) {
        super(locationName, locationDescription, locationCoordinates);
        this.lunchPrice = lunchPrice;
    }

    public double getLunchPrice() {
        return lunchPrice;
    }

    public void setLunchPrice(double lunchPrice) {
        this.lunchPrice = lunchPrice;
    }

    @Override
    public double getEntryFee() {
        return getLunchPrice();
    }

    @Override
    public LocalTime getStartHour() {
        return LocalTime.parse("10:00");
    }

    @Override
    public LocalTime getFinishHour() {
        return LocalTime.parse("22:00");
    }

    @Override
    public int getRank() {
        return rank;
    }

    public int setRank(int rank) {
        return this.rank = rank;
    }

    @Override
    public String toString() {
        return "\n Restaurant { " +
                "RestaurantName = " + getLocationName() +
                ", lunchPrice=" + getEntryFee() +
                ", ranking=" + getRank() +
                ", openingHour = " + getStartHour() +
                ", closingHour = " + getFinishHour() +
                '}';
    }
}
