package optional.lab5.command;

import optional.lab5.command.Command;
import optional.lab5.model.Catalog;

public class ListCommand implements Command {

    private Catalog catalog;

    public ListCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void execute(Object catalog) {
        System.out.println(((Catalog) catalog).getItems().toString());
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
}