package optional.lab2;

/**
 * Auxiliary is an additional class to store the supplies and demands line per line
 * It consists of :
 * <ul>
 *     <li> A supply for a source </li>
 *     <li> A demand for a destination </li>
 *     <li> A value that stores the cost from a source to destination </li>
 * </ul>
 *
 * @author Dmitri Cojocari
 * @version 1.0
 */

public class Auxiliary {

        private int supply;
        private int demand;
        private int value;

        public Auxiliary(){
            this.supply = 0;
            this.demand = 0;
        }

        public Auxiliary(int supply, int demand){
            this.supply = supply;
            this.demand = demand;
        }

        public int getSupply() {
            return supply;
        }

        public void setSupply(int supply) {
            this.supply = supply;
        }

        public int getDemand() {
            return demand;
        }

        public void setDemand(int demand) {
            this.demand = demand;
        }

        public double getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

    @Override
    public String toString() {
        return "Auxiliary{" +
                "supply " + (supply+1) +
                " -> demand " + (demand+1) + " " +
                value  + "units" +
                '}';
    }
}
