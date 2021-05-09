package net.jsrois.moviesserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MoviesController {

    private List<Movie> movies;

    public MoviesController() {
        movies = List.of(
                new Movie("Kingdom of Heaven", 2005),
                new Movie("Judas and the Black Messiah", 2021),
                new Movie("Toy Story", 1995)
        );
    }

    @GetMapping("/movies")
    public List<Movie> allMovies() {
        return movies;
    }


}
