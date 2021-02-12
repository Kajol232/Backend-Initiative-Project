package com.example.muhammad.backendinitiative.levelone.arraycrudapi.controller;

import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.Movie;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.Rentals;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.Response;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.repository.RentalRepositories;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.service.serviceImplementation.RentalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rentals")
public class RentalController {
    @Autowired
    private RentalServiceImpl rentalService;
    @Autowired
    private RentalRepositories rentalRepositories;

    private Response response = new Response();

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(path = "lists", produces = "application/json")
    public List<Rentals> getAllRentals(){
        return (List<Rentals>) rentalRepositories.findAll();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(path = "/getRental/{id}", produces = "application/json")
    public Rentals getRentalById(@PathVariable(value = "id") int id){

        return rentalRepositories.findById(id).get();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(path ="/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Object addRental(@RequestBody Rentals rentals){

        return rentalService.addRentals(rentals);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(path = "/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Object editRental(@RequestBody Rentals rentals, @PathVariable(value = "id") int id){

        return rentalService.editRentals(id, rentals);

    }

    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping(path = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object deleteRental(@PathVariable("id") int id) {
        Rentals r = rentalRepositories.findById(id).get();
        rentalRepositories.delete(r);
        response.setStatus("00");
        response.setMessage("Rental deleted");
        return response;
    }

}
