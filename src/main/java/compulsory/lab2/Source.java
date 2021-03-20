package compulsory.lab2;

public class Source {
    private int supply;
    private SourceType type;
    private String name;

    public Source(int supply, SourceType type, String name) {
        this.supply = supply;
        this.type = type;
        this.name = name;
    }

    public int getSupply() {
        return supply;
    }

    public void setSupply(int supply) {
        this.supply = supply;
    }

    public SourceType getType() {
        return type;
    }

    public void setType(SourceType type) {
        this.type = type;
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
                ", type= " + type +
                ", name= " + name + '\'' +
                "}\n";
    }
}
