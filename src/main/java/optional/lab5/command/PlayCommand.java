package optional.lab5.command;

import optional.lab5.command.Command;
import optional.lab5.model.Catalog;
import optional.lab5.model.Item;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PlayCommand implements Command {

    private Catalog catalog;

    public PlayCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void execute(Object catalog) throws IOException {
        Desktop d = Desktop.getDesktop();
        for (Item item : ((Catalog) catalog).getItems()) {
            d.open(new File(item.getPath()));
        }
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

}
