package optional.lab7.player;

import optional.lab7.game.Board;
import optional.lab7.game.Token;

public class BotPlayer extends Player {

    public BotPlayer(String playerName, Board board) {
        this.setPlayerName(playerName);
        this.setBoard(board);
    }

    @Override
    public synchronized void run() {
        try {
            System.out.println("Player name is waiting -> " + getPlayerName());
            wait();

            while (true) {
                Token token = getBoard().getToken();
                Thread.sleep(500);

                if (token != null) {
                    getSelectedTokens().add(token);
                    calculateScore();
                    System.out.println(this.getPlayerName() + " selectedTokens: " + getSelectedTokens().toString());
                    System.out.println(this.getPlayerName() + " score: " + getScore());
                    getGameManager().madeMove();
                } else {
                    getGameManager().onGameOver();
                    wait();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
