package optional.lab2;

import java.util.Objects;

/**
 * Source is an abstract class to describe the sources in the given problem
 * Each source has :
 * <ul>
 *     <li> The amount of commodities it can provide to the destinations  </li>
 *     <li> A name </li>
 * </ul>
 *
 * @author Dmitri Cojocari
 * @version 1.0
 */

public abstract class Source {
    private int supply;
    private String name;

    public Source(int supply,  String name) {
        this.supply = supply;
        this.name = name;
    }

    public int getSupply() {
        return supply;
    }

    public void setSupply(int supply) {
        this.supply = supply;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Source{" +
                "supply= " + supply +
                ", name= " + name + '\'' +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;
        return supply == source.supply && name.equals(source.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supply, name);
    }
}
