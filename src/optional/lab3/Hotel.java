package optional.lab3;

public class Hotel extends Location implements Payable, Classifiable {

    private double pricePerNight;
    private int stars;

    public Hotel(String locationName, String locationDescription, String locationCoordinates, double pricePerNight) {
        super(locationName, locationDescription, locationCoordinates);
        this.pricePerNight = pricePerNight;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    @Override
    public double getEntryFee() {
        return getPricePerNight();
    }

    @Override
    public int getRank() {
        return stars;
    }

    public int setStars(int stars) {
        return this.stars = stars;
    }

    @Override
    public String toString() {
        return "\n Hotel { " +
                "HotelName = " + getLocationName() +
                ", pricePerNight = " + pricePerNight +
                ", stars = " + getRank() +
                '}';
    }
}
