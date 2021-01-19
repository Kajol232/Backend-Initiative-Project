package com.example.muhammad.backendinitiative.levelone.arraycrudapi.repository;

import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.RegisterUser;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.Response;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.model.User;
import com.example.muhammad.backendinitiative.levelone.arraycrudapi.repositoryInterface.UserRepositoryInterface;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositories implements UserRepositoryInterface {
    private List<User> userList = new ArrayList<User>();
    private Response response = new Response();

    public Response addUser(User u) {
        if (userList.isEmpty()) {
            u.setId(0);
        } else {
            int id = userList.size() + 1;
            u.setId(id);
        }
        userList.add(u);
        response.setStatus("00");
        response.setMessage("User created successfully");

        return response;
    }

    public Response editUser(int id, User user){
        userList.set(id, user);
        response.setStatus("00");
        response.setMessage("User updates successful");

        return response;
    }

    public User getUserById(int id){
        return  userList.get(id);
    }

    public List<User> searchUser(String query){
        List<User> results = new ArrayList<User>();
        for (User u:userList) {
            if (u.getName().equalsIgnoreCase(query) || u.getUsername().equalsIgnoreCase(query) ||
            u.getEmail().equalsIgnoreCase(query)){
                results.add(u);
            }
        }
        return results;
    }

    public List<User> getUserList(){
        if (userList != null){
            return userList;
        }
        return null;
    }

    public String deleteUser(int id){
        userList.remove(id);
        response.setStatus("00");
        response.setMessage("User Deleted");
        return "Successful";
    }

    @Override
    public boolean existsByEmail(String email) {
        for (User u:userList) {
            if (u.getEmail().equalsIgnoreCase(email)){
                return true;
            }

        }

        return false;
    }


}
