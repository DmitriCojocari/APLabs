package compulsory.lab9.repository;

import compulsory.lab9.model.Movie;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class MovieRepository {

    private EntityManager entityManager;

    public MovieRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public Optional<Movie> findById(Integer id) {
        Movie movie = entityManager.find(Movie.class, id);
        return movie != null ? Optional.of(movie) : Optional.empty();
    }
    public List<Movie> findAll() {
        return entityManager.createQuery("from Movie").getResultList();
    }

    public Optional<Movie> findByName(String name) {
        Movie movie = (Movie) entityManager.createQuery("SELECT m FROM Movie m WHERE m.title = :name")
                .setParameter("name", name)
                .getSingleResult();
        return movie != null ? Optional.of(movie) : Optional.empty();
    }
    public Optional<Movie> findByNameNamedQuery(String name) {
        Movie movie = (Movie) entityManager.createNamedQuery("Movie.findByName")
                .setParameter("title", name)
                .getSingleResult();
        return movie != null ? Optional.of(movie) : Optional.empty();
    }
    public Optional<Movie> create(Movie movie) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(movie);
            entityManager.getTransaction().commit();
            return Optional.of(movie);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
