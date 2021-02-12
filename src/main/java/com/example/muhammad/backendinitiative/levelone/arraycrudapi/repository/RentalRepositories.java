package com.example.muhammad.backendinitiative.levelone.arraycrudapi.repository;

import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.Rentals;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepositories extends CrudRepository<Rentals,Integer> {


}
