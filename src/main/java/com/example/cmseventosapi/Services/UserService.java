package com.example.cmseventosapi.Services;

import com.example.cmseventosapi.Auth.Exceptions.UserMustBeAdminToPerformActionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.cmseventosapi.Model.User;
import com.example.cmseventosapi.Repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    public User createUser(User user){
        if(this.repository.findByLogin(user.getLogin()).isPresent()){
            throw new RuntimeException("Login already exists");
        }
        if (this.repository.findByEmail(user.getEmail()).isPresent()){
            throw new RuntimeException("Email already exists");
        }
        user.setPassword(encoder.encode(user.getPassword()));

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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User loggedUser = this.repository.findByLogin(authentication.getName()).get();
        if(!loggedUser.isAdmin()){
            throw new UserMustBeAdminToPerformActionException("You must be an admin to do this");
        }
        User userToUpdate = this.repository.findById(id).get();
        userToUpdate.setAdmin(true);
        return this.repository.save(userToUpdate);
    }

}
