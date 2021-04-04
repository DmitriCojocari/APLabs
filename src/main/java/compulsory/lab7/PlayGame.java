package compulsory.lab7;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class PlayGame {

    private List<Player> players = new ArrayList<>();
    private Board board;

    public PlayGame(int nrOfPlayers) {
        Faker faker = new Faker();
        board = new Board(faker.number().numberBetween(nrOfPlayers * 2, nrOfPlayers * 5));

        //generate random players and assign the board to everyone
        var generatedPlayers = IntStream.rangeClosed(0, nrOfPlayers - 1)
                .mapToObj(i -> new Player(faker.name().fullName(), board))
                .toArray(Player[]::new);

        //insert the generated players in list
        Collections.addAll(players, generatedPlayers);
    }

    public void play() {
        System.out.println(board.toString());
        //creating threads for each player
        var threads = IntStream.rangeClosed(0, players.size() - 1)
                .mapToObj(i -> new Thread(players.get(i)))
                .toArray(Thread[]::new);
        List<Thread> threadsList = new ArrayList<>();
        Collections.addAll(threadsList, threads);
        threadsList.forEach(thread -> thread.start());
    }

}

