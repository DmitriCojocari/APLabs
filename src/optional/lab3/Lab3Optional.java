package optional.lab3;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lab3Optional {

    public static void main(String[] args) {
        Hotel hotel1 = new Hotel("Hotel", "Center", "12.34.45N", 24.5);
        hotel1.setOpeningTime(LocalTime.of(9, 30));
        hotel1.setClosingTime(LocalTime.parse("23:30"));
        hotel1.setStars(2);

        Museum museum1 = new Museum("Museum A", "Center", "12.40.41N", 10);
        museum1.setOpeningTime(LocalTime.of(9, 00));
        museum1.setClosingTime(LocalTime.parse("17:30"));

        Museum museum2 = new Museum("Museum B", "Modern Art", "12.50.28N", 15);
        museum2.setOpeningTime(LocalTime.of(9, 15));
        museum2.setClosingTime(LocalTime.parse("18:30"));

        Church church1 = new Church("Church A", "Founded in 1923", "13.02.45N");
        church1.setOpeningTime(LocalTime.of(10, 45));
        church1.setClosingTime(LocalTime.parse("19:00"));

        Church church2 = new Church("Church B", "The one and only", "13.15.45N");
        church2.setOpeningTime(LocalTime.of(10, 00));
        church2.setClosingTime(LocalTime.parse("18:30"));

        Restaurant restaurant1 = new Restaurant("Restaurant", "Centre square", "13.20.56N", 15);
        restaurant1.setOpeningTime(LocalTime.of(10, 15));
        restaurant1.setClosingTime(LocalTime.parse("23:30"));

        restaurant1.setRank(100);

        Map<Location, Integer> hotel1Timing = new HashMap<>();
        hotel1Timing.put(museum1, 10);
        hotel1Timing.put(museum2, 50);
        hotel1.setRequiredTimes(hotel1Timing);

        Map<Location, Integer> museum1Timing = new HashMap<>();
        museum1Timing.put(museum2, 20);
        museum1Timing.put(church1, 20);
        museum1Timing.put(church2, 10);
        museum1.setRequiredTimes(museum1Timing);

        Map<Location, Integer> museum2Timing = new HashMap<>();
        museum2Timing.put(church1, 20);
        museum2Timing.put(museum1, 20);
        museum2.setRequiredTimes(museum2Timing);

        Map<Location, Integer> church1Timing = new HashMap<>();
        church1Timing.put(church2, 30);
        church1Timing.put(restaurant1, 10);
        church1.setRequiredTimes(church1Timing);

        Map<Location, Integer> church2Timing = new HashMap<>();
        church2Timing.put(restaurant1, 20);
        church2Timing.put(church1, 30);
        church2.setRequiredTimes(church2Timing);

        Map<Location, Integer> restaurant1Timing = new HashMap<>();
        restaurant1Timing.put(hotel1, 15);
        restaurant1.setRequiredTimes(restaurant1Timing);

        List<Location> locations = new ArrayList<>();
        locations.add(hotel1);
        locations.add(museum1);
        locations.add(museum2);
        locations.add(church1);
        locations.add(church2);
        locations.add(restaurant1);

        City city1 = new City("Iasi", locations);
        System.out.println(city1.toString());
        System.out.println("\nVisitable, not Payable locations ordered by opening time: " + city1.displayVisitableNotPayable(locations));
        System.out.println("\nAmount of hours a location is open a day=" + Visitable.getVisitingDuration().getDuration());

        System.out.println();
        Graph graph = new Graph();
        graph.addLocation(hotel1);
        graph.addLocation(museum1);
        graph.addLocation(museum2);
        graph.addLocation(church1);
        graph.addLocation(church2);
        graph.addLocation(restaurant1);

        graph = Graph.calculateShortestPathFromSource(graph, hotel1);

        System.out.println("Minimal distance to all locations : \n");
        for (Location location : graph.getNodes()) {
            for (Location l : location.getShortestPath()) {
                System.out.print(l.getLocationName() + " -> ");
            }
            System.out.print(location.getLocationName());

            System.out.println(", Time = " + location.getDistance());
        }

    }
}
