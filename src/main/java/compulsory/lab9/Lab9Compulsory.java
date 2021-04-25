package compulsory.lab9;

import compulsory.lab9.model.Movie;
import compulsory.lab9.repository.MovieRepository;
import compulsory.lab9.util.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;

public class Lab9Compulsory {

    public static void main(String[] args) throws Exception {

        EntityManagerFactory entityManagerFactory = PersistenceManager.getInstance().getEntityManagerFactory();

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        MovieRepository movieRepository = new MovieRepository(entityManager);

        Movie movieToAdd = new Movie(6, "Me, Myself and I", "14/03/2021", 50, 8.5f);
        movieRepository.create(movieToAdd);

        Optional<Movie> foundMovie = movieRepository.findById(6);
        foundMovie.ifPresent(System.out::println);

        foundMovie = movieRepository.findById(2);
        foundMovie.ifPresent(System.out::println);

        // Search for a movie with an invalid ID
        Optional<Movie> notFoundMovie = movieRepository.findById(99);
        notFoundMovie.ifPresent(System.out::println);

        // List all movies
        List<Movie> movies = movieRepository.findAll();
        System.out.println("Movies in database:");
        movies.forEach(System.out::println);

        // Find a movie by name
        Optional<Movie> queryMovie1 = movieRepository.findByName("Paper Towns");
        System.out.println("Query for Paper Towns:");
        queryMovie1.ifPresent(System.out::println);

        // Find a movie by name using a named query
        Optional<Movie> queryMovie2 = movieRepository.findByNameNamedQuery("Last Dance");
        System.out.println("Query for Last Dance");
        queryMovie2.ifPresent(System.out::println);

        entityManager.close();
        PersistenceManager.getInstance().closeEntityManagerFactory();


    }

}

