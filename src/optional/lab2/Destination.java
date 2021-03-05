package optional.lab2;

/**
 * Destination is a class to describe the destinations in the given problem
 * Each destination has :
 * <ul>
 *     <li> The amount of commodities it can receives from  the sources  </li>
 *     <li> A name </li>
 * </ul>
 *
 * @author Dmitri Cojocari
 * @version 1.0
 */

public class Destination {
    private int demand;
    private String name;

    public Destination(int demand, String name) {
        this.demand = demand;
        this.name = name;
    }

    public int getDemand() {
        return demand;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Destination{" +
                " demand=" + demand +
                ", name='" + name + '\'' +
                "}\n";
    }
}
