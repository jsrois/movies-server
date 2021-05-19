package net.jsrois.moviesserver;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MoviesController {

    private List<Movie> movies;

    public MoviesController() {
        movies = new ArrayList<>();
    }

    @GetMapping("/movies")
    public List<Movie> allMovies() {
        return movies;
    }

    @PostMapping("/movies")
    public RedirectView addNewMovie(Movie movie) {
        movies.add(movie);
        return new RedirectView("/");
    }

    @DeleteMapping("/movies/{index}")
    void deleteMovie(@PathVariable int index) {
        movies.remove(index);
    }
}
