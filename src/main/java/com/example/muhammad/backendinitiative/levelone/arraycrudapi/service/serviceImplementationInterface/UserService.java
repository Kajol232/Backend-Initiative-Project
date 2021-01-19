package com.example.muhammad.backendinitiative.levelone.arraycrudapi.service.serviceImplementationInterface;

import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.RegisterUser;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.User;


public interface UserService {
    Object addUser(RegisterUser user);
    Object editUser(int id, User user);

}
