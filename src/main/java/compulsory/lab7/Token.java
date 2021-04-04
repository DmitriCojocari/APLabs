package compulsory.lab7;

import javafx.util.Pair;

public class Token {
    private Pair<Integer, Integer> tokenPair;
    private Integer tokenValue;

    public Token(Pair<Integer, Integer> tokenPair, Integer tokenValue) {
        this.tokenPair = tokenPair;
        this.tokenValue = tokenValue;
    }

    @Override
    public String toString() {
        return "\nToken{" +
                " tokenPair : <" + tokenPair.getKey().toString() + ", " + tokenPair.getValue() + ">" +
                " tokenValue = " + tokenValue +
                "}\n";
    }

}
