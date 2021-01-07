package com.example.muhammad.backendinitiative.levelone.arraycrudapi.repositoryInterface;

import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.RegisterUser;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.Response;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.User;

import java.util.List;

public interface UserRepositoryInterface {
    Response addUser(User u);
    Response editUser(int id, User user);
    User getUserById(int id);
    List<User> searchUser(String query);
    List<User> getUserList();
    String deleteUser(int id);
    boolean existsByEmail(String email);
}
