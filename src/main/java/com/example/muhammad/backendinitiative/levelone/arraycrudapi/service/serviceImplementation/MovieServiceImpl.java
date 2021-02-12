package com.example.muhammad.backendinitiative.levelone.arraycrudapi.service.serviceImplementation;

import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.Movie;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.Response;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.repository.MovieRepositories;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.service.serviceImplementationInterface.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepositories movieRepositories;

    Response response = new Response();

    @Override
    public Object addMovie(Movie movie) {
        if(movie == null){
            response.setStatus("05");
            response.setMessage("Invalid movie details");
        }else {
            movieRepositories.save(movie);
            response.setStatus("00");
            response.setMessage("Movie saved successfully");
        }

        return response;
    }

    @Override
    public Object editMovie(int id, Movie movie) {
        Movie m = movieRepositories.findById(id).get();
        if (movie != null){
            m.setTitle(movie.getTitle());
            m.setYear(movie.getYear());
            m.setPrice(movie.getPrice());
            movieRepositories.save(m);
            response.setStatus("00");
            response.setMessage("Movie details updated successfully");
        }else{
            response.setStatus("403");
            response.setMessage("Movie does not exist");
        }
        return response;
    }
}
