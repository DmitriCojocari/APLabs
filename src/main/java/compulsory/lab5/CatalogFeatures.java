package compulsory.lab5;

import java.awt.*;
import java.io.*;

public class CatalogFeatures {

    public static void save(Catalog catalog) throws IOException {
        try (var oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }

    public static void list(Catalog catalog) throws IOException {
        System.out.println(catalog.toString());
    }

    public static void play(Catalog catalog) throws IOException {
        Desktop d = Desktop.getDesktop();
        for (Item item : catalog.getItems()) {
            d.open(new File(item.getPath()));
        }
    }

    public static Catalog load(Catalog catalog) throws IOException, ClassNotFoundException {
        Catalog loadedCatalog;
        try (var ois = new ObjectInputStream(new FileInputStream(catalog.getPath()))) {
            loadedCatalog = (Catalog) ois.readObject();
        }
        return loadedCatalog;
    }
}