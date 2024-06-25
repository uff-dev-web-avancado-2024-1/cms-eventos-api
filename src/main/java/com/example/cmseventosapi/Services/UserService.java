package com.example.cmseventosapi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cmseventosapi.Model.User;
import com.example.cmseventosapi.Repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public User createUser(User user){
        return this.repository.save(user);
    }

    public User updateUser(User user, Long id){
        User userToUpdate = this.repository.findById(id).get();
        userToUpdate.setName(user.getName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setLogin(user.getLogin());
        userToUpdate.setAffiliation(user.getAffiliation());
        userToUpdate.setFavoriteActivities(user.getFavoriteActivities());
        userToUpdate.setAdmin(user.isAdmin());
        userToUpdate.setOrganizedEditions(user.getOrganizedEditions());
        return this.repository.save(user);
    }

    public User getUser(Long id){
        return this.repository.findById(id).get();
    }

    public User makeAdmin(Long id){
        User userToUpdate = this.repository.findById(id).get();
        userToUpdate.setAdmin(true);
        return this.repository.save(userToUpdate);
    }

}
