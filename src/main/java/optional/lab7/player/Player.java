package optional.lab7.player;

import optional.lab7.game.Board;
import optional.lab7.game.GameManager;
import optional.lab7.game.Token;

import java.util.ArrayList;
import java.util.List;

public abstract class Player extends Thread implements Runnable {

    private String playerName;
    private List<Token> selectedTokens = new ArrayList<>();
    private Board board;
    private int score;
    private GameManager gameManager;

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Token> getSelectedTokens() {
        return selectedTokens;
    }

    public void setSelectedTokens(List<Token> selectedTokens) {
        this.selectedTokens = selectedTokens;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void calculateScore() {
        int count = 0;
        for (Token token : selectedTokens) {
            count += token.getTokenValue();
        }
        setScore(count);
    }

    public GameManager getGameManager() {
        return gameManager;
    }

    public void setGameManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", selectedTokens=" + selectedTokens +
                ", score=" + score +
                '}';
    }

}

