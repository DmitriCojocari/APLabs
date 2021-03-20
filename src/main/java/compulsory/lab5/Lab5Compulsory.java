package compulsory.lab5;

import java.io.IOException;

public class Lab5Compulsory {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Catalog catalog = new Catalog("My Catalog", "src/main/java/compulsory/lab5/resources/Catalog.txt");

        var book1 = new Book(1, "bookA", "src/main/java/compulsory/lab5/resources/bookA.txt");
        catalog.add(book1);

        var book2 = new Book(2, "bookB", "src/main/java/compulsory/lab5/resources/bookB.txt");
        catalog.add(book2);

        var song1 = new Song(3, "song1", "src/main/java/compulsory/lab5/resources/LimbaNoastra.mp3");
        catalog.add(song1);

        var video1 = new Video(4, "video1", "src/main/java/compulsory/lab5/resources/JavaHelloWorld.mp4");
        catalog.add(video1);

        CatalogFeatures.save(catalog);

        CatalogFeatures.list(catalog);

        CatalogFeatures.play(catalog);

        Catalog loadedCatalog = CatalogFeatures.load(catalog);
        CatalogFeatures.list(loadedCatalog);

        //var book3 = new Book (5, "book3", "F:\\book.txt");
    }
}
