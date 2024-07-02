package com.example.cmseventosapi.Services;

import com.example.cmseventosapi.Auth.Exceptions.UserMustBeAdminToPerformActionException;
import com.example.cmseventosapi.Model.User;
import com.example.cmseventosapi.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.cmseventosapi.Model.Event;
import com.example.cmseventosapi.Repositories.EventRepository;

@Service
public class EventService {
    
    @Autowired
    private EventRepository repository;

    @Autowired
    private UserRepository userRepository;

    public Event CreateEvent(Event event) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User loggedUser = this.userRepository.findByLogin(authentication.getName()).get();
        if(!loggedUser.isAdmin()){
            throw new UserMustBeAdminToPerformActionException("You don't have permission to do this");
        }
        return this.repository.save(event);
    }

    public Event UpdateEvent(Event event, Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User loggedUser = this.userRepository.findByLogin(authentication.getName()).get();
        if(!loggedUser.isAdmin()){
            throw new UserMustBeAdminToPerformActionException("You must be an admin to do this");
        }
        Event eventToUpdate = this.repository.findById(id).get();
        eventToUpdate.setName(event.getName());
        eventToUpdate.setDescription(event.getDescription());
        eventToUpdate.setAcronym(event.getAcronym());
        eventToUpdate.setPath(event.getPath());
        return this.repository.save(event);
    }

    public Event GetEvent(Long id) {
        return this.repository.findById(id).get();
    }

    public void DeleteEvent(Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User loggedUser = this.userRepository.findByLogin(authentication.getName()).get();
        if(!loggedUser.isAdmin()){
            throw new UserMustBeAdminToPerformActionException("You must be an admin to do this");
        }
        this.repository.deleteById(id);
    }
}
