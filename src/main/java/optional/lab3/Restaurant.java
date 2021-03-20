package optional.lab3;

public class Restaurant extends Location implements Payable, Classifiable {

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
                ", openingHour = " + getStartHour() +
                ", closingHour = " + getFinishHour() +
                '}';
    }
}
