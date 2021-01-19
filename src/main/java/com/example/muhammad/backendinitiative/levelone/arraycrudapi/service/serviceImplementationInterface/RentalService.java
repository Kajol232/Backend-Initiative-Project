package com.example.muhammad.backendinitiative.levelone.arraycrudapi.service.serviceImplementationInterface;

import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.Rentals;

public interface RentalService {
    Object addRentals(Rentals rentals);
    Object editRentals(int id, Rentals rentals);
}
