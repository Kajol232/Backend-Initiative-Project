package com.example.muhammad.backendinitiative.levelone.arraycrudapi.service.serviceImplementation;

import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.RegisterUser;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.Response;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.User;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.repository.UserRepositories;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.service.serviceImplementationInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepositories userRepositories;

    Response response = new Response();

    @Override
    public Object addUser(RegisterUser user) {
        if (!user.getPassword().equals(user.getConfirmPassword())){
            response.setStatus("401");
            response.setMessage("Password does not match");
        }else if (userRepositories.existsByEmail(user.getEmail())){
            response.setStatus("401");
            response.setMessage("User exist");
        }else if(!user.getEmail().contains("@") || !user.getEmail().contains(".")){
            response.setStatus("401");
            response.setMessage("Invalid email");
        }else if(user.getPassword().isBlank() || user.getPassword().isEmpty()){
            response.setStatus("401");
            response.setMessage("Password cannot be blank");

        }else{
            User u = new User(user.getName(),user.getDob(),user.getEmail(), user.getUsername(), user.getPassword());
            userRepositories.save(u);
            response.setStatus("00");
            response.setMessage("User added successfully");

        }

        return response;
    }

    @Override
    public Object editUser(int id, User user) {
        User u = userRepositories.findById(id).get();
        if(user != null){
            u.setName(user.getName());
            u.setDob(user.getDob());
            u.setEmail(user.getEmail());
            u.setUsername(user.getUsername());
            userRepositories.save(u);
            response.setStatus("00");
            response.setMessage("User details updated successfully");
        }else {
            response.setStatus("403");
            response.setMessage("User does not exist");
        }

        return response;
    }


}
