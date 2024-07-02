package com.example.cmseventosapi.Services;

import com.example.cmseventosapi.Auth.Exceptions.UserMustBeAdminToPerformActionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.cmseventosapi.Model.Edition;
import com.example.cmseventosapi.Model.User;
import com.example.cmseventosapi.Repositories.EditionRepository;
import com.example.cmseventosapi.Repositories.UserRepository;

@Service
public class EditionService {
    
    @Autowired
    private EditionRepository repository;

    public Edition CreateEdition(Edition edition) {
        return this.repository.save(edition);
    }

    public Edition UpdateEdition(Edition edition, Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User loggedUser = this.userRepository.findByLogin(authentication.getName()).get();
        if(!loggedUser.isAdmin()){
            throw new UserMustBeAdminToPerformActionException("You don't have permission to do this");
        }
        Edition editionToUpdate = this.repository.findById(id).get();
        editionToUpdate.setNumber(edition.getNumber());
        editionToUpdate.setYear(edition.getYear());
        editionToUpdate.setStartDate(edition.getStartDate());
        editionToUpdate.setEndDate(edition.getEndDate());
        editionToUpdate.setEvent(edition.getEvent());
        editionToUpdate.setActivities(edition.getActivities());
        return this.repository.save(edition);
    }

    public Edition GetEdition(Long id) {
        return this.repository.findById(id).get();
    }

    public void DeleteEdition(Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User loggedUser = this.userRepository.findByLogin(authentication.getName()).get();
        if(!loggedUser.isAdmin()){
            throw new UserMustBeAdminToPerformActionException("You don't have permission to do this");
        }
        this.repository.deleteById(id);
    }

    @Autowired
    private UserRepository userRepository;
    public Edition addOrganizerToEdition(Long editionId, Long userId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User loggedUser = this.userRepository.findByLogin(authentication.getName()).get();
        if(!loggedUser.isAdmin()){
            throw new UserMustBeAdminToPerformActionException("You don't have permission to do this");
        }
        Edition edition = this.repository.findById(editionId).orElseThrow(() -> new RuntimeException("Edição não encontrada"));
        User user = this.userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        user.getOrganizedEditions().add(edition);
        edition.setOrganizer(user);

        this.userRepository.save(user);
        return this.repository.save(edition);
    }
}
