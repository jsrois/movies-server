package net.jsrois.moviesserver.controllers;

import net.jsrois.moviesserver.models.Movie;
import net.jsrois.moviesserver.models.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MoviesController {
    private MovieRepository repository;

    @Autowired
    public MoviesController(MovieRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/movies")
    public ModelAndView allMovies() {
        ModelAndView modelAndView = new ModelAndView("fragments/movies");
        modelAndView.addObject("movies", repository.getMovies());
        return modelAndView;
    }

    @PostMapping("/movies")
    public RedirectView addNewMovie(Movie movie) {
        repository.addMovie(movie);
        return new RedirectView("/");
    }

    @DeleteMapping("/movies/{index}")
    @ResponseStatus(HttpStatus.OK)
    void deleteMovie(@PathVariable Integer index) {
        repository.deleteMovie(index);
    }
}
