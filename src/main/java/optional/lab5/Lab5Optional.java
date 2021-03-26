package optional.lab5;

import optional.lab5.command.*;
import optional.lab5.exception.IllegalCommandException;
import optional.lab5.model.Book;
import optional.lab5.model.Catalog;
import optional.lab5.model.Song;
import optional.lab5.model.Video;

import java.util.Scanner;

public class Lab5Optional {

    public static void main(String[] args) throws Exception {

        Catalog catalog = new Catalog("My Catalog");

        AddCommand addCommand = new AddCommand(catalog);
        SaveCommand saveCommand = new SaveCommand(catalog);
        LoadCommand loadCommand = new LoadCommand(catalog);
        ListCommand listCommand = new ListCommand(catalog);
        PlayCommand playCommand = new PlayCommand(catalog);
        ReportCommand reportCommand = new ReportCommand(catalog);
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Only next commands are available: add, list, play, save, load, report, quit.");
            System.out.println("Command add  should be followed by 3 parameters: typeOfTheItem (book, song, video), nameOfTheItem and pathToTheItem.");
            System.out.println("Commands save, load, report should be followed by 1 parameter: path.");
            System.out.println("Commands list, play, quit should not be followed by any parameters.");
            System.out.println("Please provide a command name followed by its parameters (if needed)!");

            String s = scanner.nextLine();
            String[] arg = s.split(" ");
            switch (arg[0]) {
                case "add":
                    if (arg.length == 4) {
                        switch (arg[1]) {
                            case "book":
                                var book = new Book(arg[2], arg[3]);
                                addCommand.execute(book);
                                break;
                            case "song":
                                var song = new Song(arg[2], arg[3]);
                                addCommand.execute(song);
                                break;
                            case "video":
                                var video = new Video(arg[2], arg[3]);
                                addCommand.execute(video);
                                break;
                            default:
                                throw new IllegalCommandException("Only next types of items are available: book, song, video");
                        }
                    } else {
                        throw new IllegalArgumentException("Command add accepts 3 parameters!");
                    }
                case "list":
                    listCommand.execute(catalog);
                    break;
                case "play":
                    playCommand.execute(catalog);
                    break;
                case "save":
                    if (arg.length == 2) {
                        saveCommand.execute(arg[1]);
                        break;
                    } else {
                        throw new IllegalArgumentException("Command save accepts 1 parameter!");
                    }
                case "load":
                    if (arg.length == 2) {
                        loadCommand.execute(arg[1]);
                        break;
                    } else {
                        throw new IllegalArgumentException("Command load accepts 1 parameter!");
                    }
                case "report":
                    if (arg.length == 2) {
                        reportCommand.execute(arg[1]);
                        break;
                    } else {
                        throw new IllegalArgumentException("Command report accepts 1 parameter!");
                    }
                case "quit":
                    System.exit(0);
                    break;
                default:
                    throw new IllegalCommandException("Only next commands are available: addBook, addSong, addVideo, list, play, save, load, report, quit");
            }
        } while (true);
    }

}