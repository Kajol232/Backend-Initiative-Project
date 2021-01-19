package com.example.muhammad.backendinitiative.levelone.arraycrudapi.repository;

import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.Movie;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.Response;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.repositoryInterface.MovieRepositoryInterface;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepositories implements MovieRepositoryInterface {
    private List<Movie> movieList = new ArrayList<Movie>();
    private Response response = new Response();

    public Response addNewMovie(Movie movie){
        if (movieList.isEmpty()){
            movie.setId(0);

        } else {
            int id = movieList.size() + 1;
            movie.setId(id);
        }
        movieList.add(movie);
        response.setStatus("00");
        response.setMessage("Movie created successfully");

        return response;
    }

    public Response editMovie(int id, Movie movie){
        movieList.set(id, movie);
        response.setStatus("00");
        response.setMessage("Movie updates successful");

        return response;

    }

    public Movie getMovieById(int id){

        return movieList.get(id);
    }

    public  List<Movie> searchMovie(String query){
        List<Movie> results = new ArrayList<Movie>();
        for (Movie m: movieList) {
            if(m.getTitle().equalsIgnoreCase(query) || m.getYear().equalsIgnoreCase(query)){
                results.add(m);
            }
        }
        return results;
    }

    public List<Movie> getMovieList(){
        if (movieList != null){
            return movieList;
        }
        return null;
    }

    public Object deleteMovie(int id){
        movieList.remove(id);
        response.setStatus("00");
        response.setMessage("Movie Deleted");
        return response;
    }


}
