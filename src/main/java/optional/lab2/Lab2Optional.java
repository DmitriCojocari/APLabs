package optional.lab2;

public class Lab2Optional {

    public static void main(String[] args) {
        Source source1 = new Factory (10, "Supplier1");
        Source source2 = new Warehouse (35, "Supplier2");
        Source source3 = new Warehouse (25, "Supplier3");
        Source[] sources = {source1, source2, source3};

        Destination destination1 = new Destination(20, "Destination1");
        Destination destination2 = new Destination(25, "Destination2");
        Destination destination3 = new Destination(25, "Destination3");
        Destination[] destinations = {destination1, destination2, destination3};

        int[][] costMatrix = {{2, 3, 1}, {5, 4, 8}, {5, 6, 8}};

        Problem problemInstance = new Problem(sources, destinations, costMatrix);
        System.out.println(problemInstance.toString());

        problemInstance.leastCostMethod();

        for(Auxiliary auxiliary: problemInstance.solutions){
            System.out.println(auxiliary);
        }

        System.out.println("Cost = " + problemInstance.getSolution());

    }
}
