package compulsory.lab3;

import java.util.List;

public class City implements Comparable <City> {
    private String cityName;
    private List<Location> locations;

    public City(String cityName, List<Location> locations) {
        this.cityName = cityName;
        this.locations = locations;
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
