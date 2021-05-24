package net.jsrois.moviesserver.models;

public class Movie {

    private final String title;
    private final int year;
    private boolean favourite;


    public Movie(String title, int year) {
        this.title = title;
        this.year = year;
        this.favourite = false;
    }

    public void setFavourite(boolean value) {
        this.favourite = value;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public boolean isFavourite() {
        return favourite;
    }
}
