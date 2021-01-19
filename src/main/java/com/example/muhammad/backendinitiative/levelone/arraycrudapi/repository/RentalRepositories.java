package com.example.muhammad.backendinitiative.levelone.arraycrudapi.repository;

import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.Movie;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.Rentals;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.Response;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.User;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.repositoryInterface.RentalRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RentalRepositories implements RentalRepositoryInterface {
    private List<Rentals> rentalsList = new ArrayList<Rentals>();
    private Response response = new Response();

    @Autowired
    private UserRepositories userRepositories;
    @Autowired
    private MovieRepositories movieRepositories;


    public Response addNewRental(Rentals r){
        if (rentalsList.isEmpty()){
           r.setId(0);

        }else {
            int id = rentalsList.size() + 1;
            r.setId(id);
        }
        rentalsList.add(r);
        response.setStatus("00");
        response.setMessage("Rental added");

        return response;
    }

    public Response editRental(int id, Rentals r){
        rentalsList.set(id, r);
        response.setStatus("00");
        response.setMessage("Updates Successful");

        return response;

    }

    public Rentals getRentalById(int id){

        return rentalsList.get(id);
    }

    public  List<Rentals> searchRental(String query){
        List<Rentals> results = new ArrayList<Rentals>();

        for (Rentals r: rentalsList) {
            User user = userRepositories.getUserById(r.getId());
            Movie movie = movieRepositories.getMovieById(r.getId());
            if(movie.getTitle().equalsIgnoreCase(query) || r.getRentDate().toString().equalsIgnoreCase(query) ||
            user.getUsername().equalsIgnoreCase(query) || user.getEmail().equalsIgnoreCase(query) ||
            user.getName().equalsIgnoreCase(query)){
                results.add(r);
            }
        }
        return results;
    }

    public List<Rentals> getRentalsList(){
        if (rentalsList != null){
            return rentalsList;
        }
        return null;
    }

    public Object deleteRental(int id){
        rentalsList.remove(id);
        response.setStatus("00");
        response.setMessage("Rental Deleted");
        return response;
    }
}
