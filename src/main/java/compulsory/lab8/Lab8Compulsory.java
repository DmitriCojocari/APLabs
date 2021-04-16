package compulsory.lab8;

import compulsory.lab8.dao.GenreDAO;
import compulsory.lab8.dao.MovieDAO;
import compulsory.lab8.model.Genre;
import compulsory.lab8.model.Movie;

import java.util.Scanner;

public class Lab8Compulsory {

    public static void main(String[] args) throws Exception {

        MovieDAO movie = new MovieDAO();
        Movie movieToAdd = new Movie(6, "Me, Myself and I", "14/03/2021", 50, 8.5f);

        GenreDAO genre = new GenreDAO();
        Genre genreToAdd = new Genre(6, "Sci-Fi");

        System.out.println("Initial contents of the Movies table: ");
        movie.findAll();

        System.out.println("Initial contents of the Genres table: ");
        genre.findAll();

        movie.add(movieToAdd);
        System.out.println("Updated contents of table Movies: ");
        movie.findAll();

        genre.add(genreToAdd);
        System.out.println("Updated contents of table Genres: " );
        genre.findAll();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the title to be found in the movies table : ");
        String movieToBeFound = scanner.nextLine();
        movie.findByTitle(movieToBeFound);

        System.out.println("Enter the id to be found in the movies table : ");
        int movieIdToBeFound = Integer.parseInt(scanner.nextLine());
        movie.findByID(movieIdToBeFound);

        System.out.println("Enter the title to be found in the genre table : ");
        String genreToBeFound = scanner.nextLine();
        genre.findByTitle(genreToBeFound);

        System.out.println("Enter the id to be found in the genre table : ");
        int genreIdToBeFound = Integer.parseInt(scanner.nextLine());
        genre.findByID(genreIdToBeFound);

    }

}

