package optional.lab7;

import com.github.javafaker.Faker;
import optional.lab7.game.GameManager;

public class Lab7Optional {

    public static void main(String[] args) throws InterruptedException {
        Faker faker = new Faker();
        GameManager game = new GameManager(faker.number().numberBetween(2, 4));
        game.play();
    }

}

