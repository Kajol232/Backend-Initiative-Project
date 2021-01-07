package com.example.muhammad.backendinitiative.levelone.arraycrudapi.repositoryInterface;

import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.Rentals;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.Response;

import java.util.List;

public interface RentalRepositoryInterface {
    Response addNewRental(Rentals r);
    Response editRental(int id, Rentals r);
    Rentals getRentalById(int id);
    List<Rentals> searchRental(String query);
    List<Rentals> getRentalsList();
    Object deleteRental(int id);
}
