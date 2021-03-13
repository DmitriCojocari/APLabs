package optional.lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class City implements Comparable<City> {

    private String cityName;
    private List<Location> locations;

    public City(String cityName, List<Location> locations) {
        this.cityName = cityName;
        this.locations = locations;
    }

    public String displayVisitableNotPayable(List<Location> locations) {
        List<Location> orderedLocations = new ArrayList<>();
        for (Location location : locations) {
            if ((location instanceof Visitable) && !(location instanceof Payable)) {
                orderedLocations.add(location);
            }
        }
        Collections.sort(orderedLocations);
        return orderedLocations.toString();
    }

    @Override
    public int compareTo(City city) {
        int compareValue = this.cityName.compareTo(city.cityName);
        return compareValue;
    }

    @Override
    public String toString() {
        return "City {" + '\n' +
                " cityName= " + cityName +
                "\n locations=" + locations + '\n' +
                '}';
    }
}
