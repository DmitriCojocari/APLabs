package compulsory.lab5;

import java.io.IOException;

public class InvalidFilePath extends RuntimeException {

    public InvalidFilePath(String path) {
        super(path);
        System.out.println("Error! The path you entered : " + path + " is invalid. Please try again!");
    }
}
