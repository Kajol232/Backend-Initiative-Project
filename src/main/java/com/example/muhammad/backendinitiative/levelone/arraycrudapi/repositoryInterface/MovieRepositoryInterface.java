package com.example.muhammad.backendinitiative.levelone.arraycrudapi.repositoryInterface;

import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.Movie;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.Response;

import java.util.List;

public interface MovieRepositoryInterface {
    Response addNewMovie(Movie movie);
    Response editMovie(int id, Movie movie);
    Movie getMovieById(int id);
    List<Movie> searchMovie(String query);
    List<Movie> getMovieList();
    Object deleteMovie(int id);
}
