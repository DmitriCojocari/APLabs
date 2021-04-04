package compulsory.lab7;

import com.github.javafaker.Faker;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Board {

    private final List<Token> tokens;

    public Board(int nrOfTokens) {
        Faker faker = new Faker();
        var generatedTokens = IntStream.rangeClosed(0, nrOfTokens - 1)
                .mapToObj(i -> new Token(new Pair<>(faker.number().numberBetween(2, 9), faker.number().numberBetween(2, 9)), faker.number().numberBetween(2, 9)))
                .toArray(Token[]::new);

        //add tokens to synch list so we can assure data integrity
        tokens = Collections.synchronizedList(new ArrayList<>());
        Collections.addAll(tokens, generatedTokens);
    }

    //synch so players can't remove the same token from the board
    //each player will take the first token from the current list of tokens
    public synchronized Token getToken() {
        if (tokens.size() > 0) {
            Token currentToken = tokens.get(0);
            tokens.remove(currentToken);
            return currentToken;
        }
        return null;
    }

    @Override
    public String toString() {
        return "\nBoard tokens size = " + tokens.size() + "\nBoard{" +
                "tokens=" + tokens +
                '}';
    }

}