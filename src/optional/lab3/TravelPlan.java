package optional.lab3;

import java.util.List;

public class TravelPlan {

    private City city;
    private List<Location> locationPreferences;

    public TravelPlan(City city, List<Location> locationPreferences) {
        this.city = city;
        this.locationPreferences = locationPreferences;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Location> getLocationPreferences() {
        return locationPreferences;
    }

    public void setLocationPreferences(List<Location> locationPreferences) {
        this.locationPreferences = locationPreferences;
    }
}
