package net.jsrois.moviesserver.controllers;

import net.jsrois.moviesserver.models.Movie;
import net.jsrois.moviesserver.models.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class MoviesController {
    private MovieRepository repository;

    @Autowired
    public MoviesController(MovieRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/movies")
    public ModelAndView allMovies(@RequestParam(defaultValue = "false", required = false) boolean favourites) {
        ModelAndView modelAndView = new ModelAndView("fragments/movies");
        Map<Integer, Movie> movies = repository.getMovies();
        if (favourites) {
            movies = movies.entrySet()
                    .stream()
                    .filter(entry -> entry.getValue().isFavourite())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        }

        modelAndView.addObject("movies", movies);
        return modelAndView;
    }

    @PostMapping("/movies")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addNewMovie(Movie movie) {
        repository.addMovie(movie);
    }

    @DeleteMapping("/movies/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMovie(@PathVariable Integer id) {
        repository.deleteMovie(id);
    }

    @PutMapping("/movies/{id}/favourite/{markAsFavourite}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void setFavourite(@PathVariable Integer id, @PathVariable boolean markAsFavourite){
        repository.updateMovie(id, markAsFavourite);
    }
}
