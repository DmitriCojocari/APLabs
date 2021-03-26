package optional.lab5.command;

import optional.lab5.command.Command;
import optional.lab5.model.Catalog;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveCommand implements Command {

    private Catalog catalog;

    public SaveCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    public void execute(Object catalogPath) throws IOException {
        try (var oos = new ObjectOutputStream(new FileOutputStream((String) catalogPath))) {
            oos.writeObject(getCatalog());
        }
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
}