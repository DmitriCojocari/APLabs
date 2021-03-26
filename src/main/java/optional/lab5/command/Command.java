package optional.lab5.command;

import java.io.IOException;

public interface Command {
    void execute(Object param) throws Exception;
}
