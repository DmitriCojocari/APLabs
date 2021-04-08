package optional.lab7.game;

import javafx.util.Pair;

public class Token {
    private Pair<Integer, Integer> tokenPair;
    private Integer tokenValue;

    public Token(Pair<Integer, Integer> tokenPair, Integer tokenValue) {
        this.tokenPair = tokenPair;
        this.tokenValue = tokenValue;
    }

    public Integer getTokenValue() {
        return tokenValue;
    }

    @Override
    public String toString() {
        return "Token{" +
                " tokenPair : <" + tokenPair.getKey().toString() + ", " + tokenPair.getValue() + ">" +
                " tokenValue = " + tokenValue +
                "}\n";
    }

}


