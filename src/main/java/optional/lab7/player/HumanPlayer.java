package optional.lab7.player;

import optional.lab7.game.Board;
import optional.lab7.game.Token;

import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(String playerName, Board board) {
        this.setPlayerName(playerName);
        this.setBoard(board);
    }

    @Override
    public synchronized void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Player name is waiting -> " + getPlayerName());
            wait();

            while (true) {
                Token token = null;
                if (getBoard().getTokensSize() > 0) {
                    System.out.println(String.format("You have available %d tokens. Please choose token! ", getBoard().getTokensSize()));
                    token = getBoard().getToken(scanner.nextInt() - 1);
                    Thread.sleep(500);
                }

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