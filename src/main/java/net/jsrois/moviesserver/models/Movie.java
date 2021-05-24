package net.jsrois.moviesserver.models;

public class Movie {

    private final String title;
    private final int year;
    private final boolean favourite = false;

    public Movie(String title, int year){
        this.title = title;
        this.year = year;
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
