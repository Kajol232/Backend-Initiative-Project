package com.example.muhammad.backendinitiative.levelone.arraycrudapi.service.serviceImplementationInterface;

import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.Movie;


public interface MovieService {
    Object addMovie(Movie movie);
    Object editMovie(int id, Movie movie);
}
