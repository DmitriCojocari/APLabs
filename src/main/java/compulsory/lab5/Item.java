package compulsory.lab5;

import java.io.Serializable;

public interface Item extends Serializable {
    Integer getId();
    String getName();
    String getPath();

}
