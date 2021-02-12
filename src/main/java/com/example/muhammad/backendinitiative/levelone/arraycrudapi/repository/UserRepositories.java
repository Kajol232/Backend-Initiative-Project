package com.example.muhammad.backendinitiative.levelone.arraycrudapi.repository;

import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepositories extends CrudRepository<User,Integer> {
    boolean existsByEmail(String email);


}
