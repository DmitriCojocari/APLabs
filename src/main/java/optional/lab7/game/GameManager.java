package optional.lab7.game;

import com.github.javafaker.Faker;
import optional.lab7.daemon.TimeKeeper;
import optional.lab7.player.BotPlayer;
import optional.lab7.player.HumanPlayer;
import optional.lab7.player.Player;

import java.util.*;
import java.util.stream.IntStream;

public class GameManager {

    List<Player> players = new ArrayList<>();
    Board board;
    private int currentPlayerPosition;

    public GameManager(int nrOfPlayers) {
        init(nrOfPlayers);
    }

    private void init(int nrOfPlayers) {
        Faker faker = new Faker();
        this.board = new Board(nrOfPlayers * 2);

        var generatedBotPlayers = IntStream.rangeClosed(0, nrOfPlayers / 2 - 1)
                .mapToObj(i -> new BotPlayer("Bot ->" + faker.name().fullName(), board))
                .toArray(Player[]::new);
        System.out.println("generatedBotPlayers " + Arrays.toString(generatedBotPlayers));

        var generatedHumanPlayers = IntStream.rangeClosed(nrOfPlayers / 2, nrOfPlayers - 1)
                .mapToObj(i -> new HumanPlayer("Human ->" + faker.name().fullName(), board))
                .toArray(Player[]::new);
        System.out.println("generatedHumanPlayers " + Arrays.toString(generatedHumanPlayers));

        Collections.addAll(players, generatedHumanPlayers);
        Collections.addAll(players, generatedBotPlayers);
        System.out.println("Number of players " + players.size());
    }

    public void play() throws InterruptedException {
        TimeKeeper timeKeeperDaemon = new TimeKeeper();
        timeKeeperDaemon.setGameManager(this);
        timeKeeperDaemon.setDaemon(true);
        timeKeeperDaemon.start();

        for (Player player : players) {
            player.setGameManager(this);
            player.start();
        }
        Thread.sleep(1000);
        synchronized (players.get(currentPlayerPosition)) {
            players.get(currentPlayerPosition).notify();
        }
    }

    public Player getWinner() {
        return players.stream().max(Comparator.comparing(Player::getScore)).get();
    }

    public void onGameOver() {
        System.out.println(String.format("The winner is %s with a score of %d", getWinner().getPlayerName(), getWinner().getScore()));
        players.forEach(Thread::interrupt);
    }

    public void madeMove() throws InterruptedException {
        int playerPosition = currentPlayerPosition;
        currentPlayerPosition++;

        if (currentPlayerPosition == players.size()) {
            currentPlayerPosition = 0;
        }

        synchronized (players.get(currentPlayerPosition)) {
            players.get(currentPlayerPosition).notify();
        }

        synchronized (players.get(playerPosition)) {
            players.get(playerPosition).wait();
        }
    }

}

