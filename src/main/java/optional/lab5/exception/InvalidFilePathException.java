package optional.lab5.exception;

import java.io.IOException;

public class InvalidFilePathException extends RuntimeException {

    public InvalidFilePathException(String path) {
        super(path);
        System.out.println("Error! The path you entered : " + path + " is invalid. Please try again!");
    }
}
