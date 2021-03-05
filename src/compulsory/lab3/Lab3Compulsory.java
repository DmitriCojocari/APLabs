package compulsory.lab3;

import java.util.*;

public class Lab3Compulsory {

    public static void main(String[] args) {
        Hotel hotel1 = new Hotel("Hotel", "Center", "12.34.45N", 24.5);

        hotel1.setStars(2);

        Museum museum1 = new Museum("Museum A", "Center", "12.40.41N", 10);

        Museum museum2 = new Museum("Museum B", "Modern Art", "12.50.28N", 15);

        Church church1 = new Church("Church A", "Founded in 1923", "13.02.45N");

        Church church2 = new Church("Church B", "The one and only", "13.15.45N");

        Restaurant restaurant1 = new Restaurant("Restaurant", "Centre square", "13.20.56N", 15);

        restaurant1.setRank(100);

        Map<Location, Integer> hotel1Timing = new HashMap<>();
        hotel1Timing.put(museum1, 10);
        hotel1Timing.put(museum2, 50);

        Map<Location, Integer> museum1Timing = new HashMap<>();
        museum1Timing.put(museum2, 20);
        museum1Timing.put(church1, 20);
        museum1Timing.put(church2, 10);

        Map<Location, Integer> museum2Timing = new HashMap<>();
        museum2Timing.put(church1, 20);

        Map<Location, Integer> church1Timing = new HashMap<>();
        church1Timing.put(church2, 30);
        church1Timing.put(restaurant1, 10);

        Map<Location, Integer> church2Timing = new HashMap<>();
        church2Timing.put(restaurant1, 20);

        List<Location> locations = new ArrayList<>();
        locations.add(hotel1);
        locations.add(museum1);
        locations.add(museum2);
        locations.add(church1);
        locations.add(church2);
        locations.add(restaurant1);

        City city1 = new City("Iasi", locations);
        System.out.println(city1.toString());
        Collections.sort(locations);
        System.out.println("Natural ordering : " + locations);
    }
}
