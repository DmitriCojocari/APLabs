package optional.lab7.daemon;

import optional.lab7.game.GameManager;

public class TimeKeeper extends Thread {

    private GameManager gameManager;

    public void run() {
        System.out.println("\nEntering TimeKeeper run method");
        long start = System.currentTimeMillis();

        try {
            System.out.println("\nTimeKeeper's run Method: currentThread() is" + Thread.currentThread());

            while (true) {
                try {
                    Thread.sleep(1000);
                    long finish = System.currentTimeMillis();
                    if ((finish - start) >= 20000) {
                        System.out.println("\nDuration of the game was exceeded!");
                        System.exit(1);
                    }
                } catch (InterruptedException x) {
                }
            }
        } finally {
            System.out.println("Leaving TimeKeeper's run Method");
        }
    }

    public void setGameManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }
}

