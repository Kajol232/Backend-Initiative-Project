package com.example.muhammad.backendinitiative.levelone.arraycrudapi.controller;

import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.RegisterUser;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.User;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.repository.UserRepositories;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.service.serviceImplementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserRepositories userRepositories;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(path = "/lists", produces = "application/json")
    public List<User> getAllUsers(){
        return userRepositories.getUserList();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(path = "/getUser/{id}", produces = "application/json")
    public User getUserById(@PathVariable(value = "id") int id){
        return userRepositories.getUserById(id);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(path = "add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Object addUser(@RequestBody RegisterUser user){
        return userService.addUser(user);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(path = "/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Object editUser(@RequestBody User user, @PathVariable(value = "id") int id){
        return userService.editUser(id, user);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping(path = "/delete/{id}", produces = "application/json")
    public Object deleteUser(@PathVariable("id") int id){
        return userRepositories.deleteUser(id);
    }

}
