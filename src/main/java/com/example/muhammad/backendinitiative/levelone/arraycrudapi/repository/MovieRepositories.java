package com.example.muhammad.backendinitiative.levelone.arraycrudapi.repository;

import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepositories extends CrudRepository<Movie, Integer> {


}
