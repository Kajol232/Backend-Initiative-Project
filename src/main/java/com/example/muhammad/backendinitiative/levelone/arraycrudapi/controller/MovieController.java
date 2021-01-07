package com.example.muhammad.backendinitiative.levelone.arraycrudapi.controller;

import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.Movie;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.repository.MovieRepositories;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.service.serviceImplementation.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieServiceImpl movieService;
    @Autowired
    private MovieRepositories movieRepositories;


    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(path = "/list", produces = "application/json")
    public List<Movie> getAllMovies(){
        return movieRepositories.getMovieList();

    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(path = "/getMovie/{id}", produces = "application/json")
    public Movie getMovieById(@PathVariable(value = "id") int id){

        return movieRepositories.getMovieById(id);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(path ="/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Object addMovie(@RequestBody Movie movie){

       return movieService.addMovie(movie);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(path = "/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Object editMovie(@RequestBody Movie movie, @PathVariable(value = "id") int id){
        return movieService.editMovie(id, movie);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping(path = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object deleteMovie(@PathVariable("id") int id){
        return movieRepositories.deleteMovie(id);
    }
}
