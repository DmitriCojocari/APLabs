package compulsory.lab9.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "GENRES")
public class Genre {
    @Id
    private int id;

    @Column(name = "GENRE_NAME")
    String name;

    @ManyToMany(mappedBy = "genres", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Movie> movies = new HashSet<>();

    public Genre() {

    }

    public Genre (String name) {
        this.name=name;
    }

    public Genre(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
        movie.getGenres().add(this);
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
