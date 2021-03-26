package optional.lab5.command;

import optional.lab5.command.Command;
import optional.lab5.model.Catalog;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class LoadCommand implements Command {

    private Catalog catalog;

    public LoadCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void execute(Object catalogPath) throws Exception {
        Catalog loadedCatalog;
        try (var ois = new ObjectInputStream(new FileInputStream(((String) catalogPath)))) {
            loadedCatalog = (Catalog) ois.readObject();
        }
        System.out.println("Loaded catalog : " + loadedCatalog.toString());
    }

}
