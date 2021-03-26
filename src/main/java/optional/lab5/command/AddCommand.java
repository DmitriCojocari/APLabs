package optional.lab5.command;

import optional.lab5.model.Catalog;
import optional.lab5.model.Item;

import java.io.IOException;

public class AddCommand implements Command {

    private Catalog catalog;

    public AddCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void execute(Object itemToAdd) throws IOException {
        catalog.getItems().add((Item) itemToAdd);
    }

}
