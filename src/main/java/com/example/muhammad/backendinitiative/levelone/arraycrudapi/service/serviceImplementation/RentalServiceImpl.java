package com.example.muhammad.backendinitiative.levelone.arraycrudapi.service.serviceImplementation;

import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.Rentals;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.Response;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.repository.RentalRepositories;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.service.serviceImplementationInterface.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalServiceImpl implements RentalService {
    @Autowired
    RentalRepositories rentalRepositories;
    Response response = new Response();

    @Override
    public Object addRentals(Rentals rentals) {
        if(rentals == null){
            response.setStatus("05");
            response.setMessage("Invalid rental details");
        }else {
            response = rentalRepositories.addNewRental(rentals);
        }
        return response;
    }

    @Override
    public Object editRentals(int id, Rentals rentals) {
        Rentals r = rentalRepositories.getRentalById(id);
        if (rentals != null){
            r.setMovie(rentals.getMovie());
            r.setPrice(rentals.getPrice());
            r.setRentDate(rentals.getRentDate());
            r.setUser(rentals.getUser());
            r.setReturnDate(rentals.getReturnDate());
            response = rentalRepositories.editRental(id, r);
        }else{
            response.setStatus("403");
            response.setMessage("Rental does not exist");
        }
        return response;
    }
}
