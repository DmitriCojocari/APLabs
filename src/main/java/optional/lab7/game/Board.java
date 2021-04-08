package optional.lab7.game;

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

        tokens = Collections.synchronizedList(new ArrayList<>());
        Collections.addAll(tokens, generatedTokens);
        //Collections.shuffle(tokens);

        System.out.println("Number of tokens " + tokens.size());
    }

    public synchronized Token getToken() {
        if (tokens.size() > 0) {
            Token currentToken = tokens.get(0);
            tokens.remove(currentToken);
            System.out.println("\nThread name is working -> " + Thread.currentThread().getName());
            return currentToken;
        }
        return null;
    }

    public synchronized Token getToken(int indexOfToken) {
        if (indexOfToken < tokens.size()) {
            Token currentToken = tokens.get(indexOfToken);
            tokens.remove(currentToken);
            System.out.println("\nThread name is working -> " + Thread.currentThread().getName());
            return currentToken;
        }
        return null;
    }

    public int getTokensSize() {
        return tokens.size();
    }

    @Override
    public String toString() {
        return "Board{" +
                "tokens=" + tokens +
                '}';
    }
}
