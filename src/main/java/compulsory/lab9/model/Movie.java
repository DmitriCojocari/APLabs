package compulsory.lab9.model;

import javax.persistence.*;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "MOVIES", schema = "STUDENT")
@NamedQueries({
        @NamedQuery(name = "Movie.findByName",
                query = "SELECT m FROM Movie m WHERE m.title = :title"),
        @NamedQuery(name = "Movie.findAll",
                query = "SELECT m FROM Movie m")
})
public class Movie implements Serializable {

    @Id
    private int id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "RELEASE_DATE")
    private Date releaseDate;

    @Column(name = "MOVIE_DURATION")
    private int duration;

    @Column(name = "RATING")
    private float rating;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "MOVIE_GENRES",
            joinColumns = @JoinColumn(name = "ID_MOVIE"),
            inverseJoinColumns = @JoinColumn(name = "ID_GENRE"))
    private Set<Genre> genres = new HashSet<>();

    public Movie() {

    }

    public Movie(int id, String title, String releaseDate, int duration, float rating) {
        this.id = id;
        this.title = title;
        this.releaseDate = parseDateReleaseString(releaseDate);
        this.duration = duration;
        this.rating = rating;
    }

    public Movie(String title) {
        this.title=title;
        this.releaseDate = new Date(new java.util.Date().getTime());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return new Date(releaseDate.getTime());
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    private Date parseDateReleaseString(String dateReleaseString) {
        try {
            java.util.Date releaseDate = new SimpleDateFormat("dd/mm/yyyy").parse(dateReleaseString);
            return new Date(releaseDate.getTime());
        } catch (ParseException e) {
            return new Date(new java.util.Date().getTime());
        }
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", duration=" + duration +
                ", rating=" + rating +
                ", genres=" + genres +
                '}';
    }
}
