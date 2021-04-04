package compulsory.lab7;

import java.util.ArrayList;
import java.util.List;

public class Player implements Runnable {

    private String playerName;
    private List<Token> selectedTokens = new ArrayList<>();
    private Board board;

    public Player(String playerName, Board board) {
        this.playerName = playerName;
        this.board = board;
    }

    @Override
    public void run() {
        try {
            Token token;
            System.out.println("****************" + this.getPlayerName() + "****************");
            do {
                token = board.getToken();
                if (token != null) {
                    selectedTokens.add(token);
                    Thread.sleep(1000);
                    //System.out.println("Player " + this.getPlayerName() + "selected : " + this.selectedTokens);
                }
            } while (token != null);
            System.out.println(this.getPlayerName() + " selectedTokens: " + selectedTokens.toString());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getPlayerName() {
        return playerName;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", selectedTokens=" + selectedTokens +
                '}';
    }

}

