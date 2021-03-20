package optional.lab2;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Problem is the class to describe the given transportation problem
 * It consists of :
 * <ul>
 *     <li> An array of sources Source </li>
 *     <li> An array of destinations Destination </li>
 *     <li> An array of supplies (for each of the sources)  </li>
 *     <li> An array of demands (for each of the destinations) </li>
 *     <li> A cost matrix, in which we store the costs from a source to a destination </li>
 *     <li> A linked list {@link java.util.LinkedList} to store the solution </li>
 * </ul>
 *
 * @author Dmitri Cojocari
 * @version 1.0
 */
public class Problem {

    private Source[] sources;

    private Destination[] destinations;

    //will be initialized in main
    private int[][] costMatrix;

    private int[] supplyArray;

    private int[] demandArray;

    LinkedList<Auxiliary> solutions = new LinkedList<Auxiliary>();

    //constructor for an instance
    public Problem(Source[] sources, Destination[] destinations, int[][] costMatrix) {
        this.sources = sources;
        this.destinations = destinations;
        this.costMatrix = costMatrix;
        //
        this.supplyArray = initSupply(sources);
        this.demandArray = initDemand(destinations);

        initSolutionList();
    }

    private void initSolutionList() {
        for (int i = 0; i < (demandArray.length + supplyArray.length - 1); i++) {
            solutions.add(new Auxiliary());
        }
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

    /**
     * The Least Cost Method is a method used to obtain the initial feasible solution for the transportation problem.
     */

    //this algorithm computes the minimal total cost (for the bonus part in lab2)
    public void leastCostMethod() {
        int min;
        int solutionsCounter = 0;

        //isChecked is responsible for checking the cell, that was already processed
        boolean[][] isChecked = new boolean[supplyArray.length][demandArray.length];
        for (int j = 0; j < demandArray.length; j++)
            for (int i = 0; i < supplyArray.length; i++)
                isChecked[i][j] = false;

        int i = 0, j = 0;
        Auxiliary minCost = new Auxiliary();

        //selecting cells by lowest cost
        while (solutionsCounter < (supplyArray.length + demandArray.length - 1)) {

            minCost.setValue(Integer.MAX_VALUE);
            //choosing the lowest cost cell
            for (int m = 0; m < supplyArray.length; m++)
                for (int n = 0; n < demandArray.length; n++)
                    if (!isChecked[m][n])
                        if (costMatrix[m][n] < minCost.getValue()) {
                            minCost.setSupply(m);
                            minCost.setDemand(n);
                            minCost.setValue(costMatrix[m][n]);
                        }

            i = minCost.getSupply();
            j = minCost.getDemand();

            //find min per line and column
            min = Math.min(demandArray[j], supplyArray[i]);

            solutions.get(solutionsCounter).setDemand(j);
            solutions.get(solutionsCounter).setSupply(i);
            solutions.get(solutionsCounter).setValue(min);
            solutionsCounter++;

            demandArray[j] -= min;
            supplyArray[i] -= min;

            //if the supplier ran out of commodities
            if (supplyArray[i] == 0) {
                //d -> index for demand array
                for (int d = 0; d < demandArray.length; d++) {
                    isChecked[i][d] = true;
                }
            } else {
                //s -> index for supply array
                for (int s = 0; s < supplyArray.length; s++) {
                    isChecked[s][j] = true;
                }
            }
        }

    }

    /**
     * Computes the optimal cost for the given instance
     * @return the result is the sum of the products of the supply cost and demand units
     */
    public int getSolution() {
        int result = 0;
        for (Auxiliary auxiliary : solutions) {
            result += auxiliary.getValue() * costMatrix[auxiliary.getSupply()][auxiliary.getDemand()];
        }

        return result;

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
