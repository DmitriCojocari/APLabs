package compulsory.lab8.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class Movie implements Serializable {

    int id;
    String title;
    Date releaseDate;
    int duration;
    float rating;

    public Movie(int id, String title, String releaseDate, int duration, float rating) {
        this.id = id;
        this.title = title;
        this.releaseDate = parseDateReleaseString(releaseDate);
        this.duration = duration;
        this.rating = rating;
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

    public java.sql.Date getReleaseDate() {
        return  new java.sql.Date(releaseDate.getTime());
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


}
