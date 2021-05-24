package net.jsrois.moviesserver.controllers;

import net.jsrois.moviesserver.models.Movie;
import net.jsrois.moviesserver.models.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@RestController
public class MoviesController {
    private MovieRepository repository;

    @Autowired
    public MoviesController(MovieRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/movies")
    public Map<Integer, Movie> allMovies() {
        return repository.getMovies();
    }

    @PostMapping("/movies")
    public RedirectView addNewMovie(Movie movie) {
        repository.addMovie(movie);
        return new RedirectView("/");
    }

    @DeleteMapping("/movies/{index}")
    void deleteMovie(@PathVariable Integer index) {
        repository.deleteMovie(index);
    }
}
