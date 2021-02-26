package compulsory.lab2;

import java.util.Arrays;

public class Problem {

    private Source[] sources;

    private Destination[] destinations;
    //will be initialized in main
    private int[][] costMatrix;

    private int[] supplyArray;

    private int[] demandArray;

    //constructor for an instance
    public Problem(Source[] sources, Destination[] destinations, int[][] costMatrix) {
        this.sources = sources;
        this.destinations = destinations;
        this.costMatrix = costMatrix;
        //
        this.supplyArray = initSupply(sources);
        this.demandArray = initDemand(destinations);
    }

    public int[] initSupply(Source[] sources) {
        supplyArray = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            supplyArray[i] = sources[i].getSupply();
        }
        return supplyArray;
    }

    public int[] initDemand(Destination[] destinations) {
        demandArray = new int[destinations.length];
        for (int i = 0; i < destinations.length; i++) {
            demandArray[i] = destinations[i].getDemand();
        }
        return demandArray;
    }

    public Source[] getSources() {
        return sources;
    }

    public void setSources(Source[] sources) {
        this.sources = sources;
    }

    public Destination[] getDestinations() {
        return destinations;
    }

    public void setDestinations(Destination[] destinations) {
        this.destinations = destinations;
    }

    public int[][] getCostMatrix() {
        return costMatrix;
    }

    public void setCostMatrix(int[][] costMatrix) {
        this.costMatrix = costMatrix;
    }

    public int[] getSupplyArray() {
        return supplyArray;
    }

    public void setSupplyArray(int[] supplyArray) {
        this.supplyArray = supplyArray;
    }

    public int[] getDemandArray() {
        return demandArray;
    }

    public void setDemandArray(int[] demandArray) {
        this.demandArray = demandArray;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "\n sources=\n" + Arrays.toString(sources) +
                ",\n destinations=\n" + Arrays.toString(destinations) +
                ",\n costMatrix=" + Arrays.deepToString(costMatrix) +
                ",\n supplyArray=" + Arrays.toString(supplyArray) +
                ",\n demandArray=" + Arrays.toString(demandArray) +
                '}';
    }
}
