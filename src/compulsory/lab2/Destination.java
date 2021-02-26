package compulsory.lab2;

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
