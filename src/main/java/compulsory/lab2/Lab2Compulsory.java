package compulsory.lab2;

public class Lab2Compulsory {

    public static void main(String[] args) {
        Source source1 = new Source(10, SourceType.FACTORY, "Supplier1");
        Source source2 = new Source(35, SourceType.WAREHOUSE, "Supplier2");
        Source source3 = new Source(25, SourceType.WAREHOUSE, "Supplier3");
        Source[] sources = {source1, source2, source3};

        Destination destination1 = new Destination(20, "Destination1");
        Destination destination2 = new Destination(25, "Destination2");
        Destination destination3 = new Destination(25, "Destination3");
        Destination[] destinations = {destination1, destination2, destination3};

        int[][] costMatrix = {{2, 3, 1}, {5, 4, 8}, {5, 6, 8}};

        Problem problemInstance = new Problem(sources, destinations, costMatrix);
        System.out.println(problemInstance.toString());
    }
}
