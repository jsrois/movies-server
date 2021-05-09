package net.jsrois.moviesserver;

public class Movie {

    private final String title;
    private final int year;
    private final String director;

    public Movie(String title, int year, String director){
        this.title = title;
        this.year = year;
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }
}
