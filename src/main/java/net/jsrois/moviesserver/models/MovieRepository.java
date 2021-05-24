package net.jsrois.moviesserver.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MovieRepository {
    private Map<Integer, Movie> movies = new HashMap<>();

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static Integer index = 0;

    public MovieRepository() {
    }

    public void addMovie(Movie movie) {
        movies.put(nextIndex(), movie);
    }

    public Map<Integer, Movie> getMovies() {
        return movies;
    }

    public void deleteMovie(Integer id) {
        Movie deletedMovie = movies.remove(id);
        if (deletedMovie == null) {
            logger.warn("Unable to remove movie with id "+ id);
        }
    }


    private Integer nextIndex() {
        return index++;
    }

    public void updateMovie(Integer id, boolean markAsFavourite) {
        Movie movie = movies.get(id);
        movie.setFavourite(markAsFavourite);
        movies.put(id, movie);
    }
}
