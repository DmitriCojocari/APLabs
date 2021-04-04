package compulsory.lab7;

import com.github.javafaker.Faker;

public class Lab7Compulsory {

    public static void main(String[] args) {
        Faker faker = new Faker();
        //randomly generate 2 - 5 players
        PlayGame game = new PlayGame(faker.number().numberBetween(2, 5));
        game.play();
    }

}

