package com.example.cmseventosapi.Services;

import com.example.cmseventosapi.Model.Edition;
import com.example.cmseventosapi.Model.Requests.CreateActivityReq;
import com.example.cmseventosapi.Model.Responses.CreateActivityResp;
import com.example.cmseventosapi.Model.Space;
import com.example.cmseventosapi.Repositories.EditionRepository;
import com.example.cmseventosapi.Repositories.SpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.cmseventosapi.Auth.Exceptions.UserMustBeAdminToPerformActionException;
import com.example.cmseventosapi.Model.Activity;
import com.example.cmseventosapi.Model.User;
import com.example.cmseventosapi.Repositories.ActivityRepository;
import com.example.cmseventosapi.Repositories.UserRepository;
import org.webjars.NotFoundException;

@Service
public class ActivityService {
    
    @Autowired
    private ActivityRepository repository;

    @Autowired
    private EditionRepository editionRepository;

    @Autowired
    private SpaceRepository spaceRepository;

    @Autowired
    private UserRepository userRepository;

    public CreateActivityResp CreateActivity(CreateActivityReq createActivityReq) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User loggedUser = this.userRepository.findByLogin(authentication.getName()).get();
        if(!loggedUser.isUserOrganizer(createActivityReq.getEditionId())){
            throw new UserMustBeAdminToPerformActionException("You must be an organizer to do this");
        }

        Space space = this.spaceRepository.findById(createActivityReq.getSpaceId()).orElseThrow(() -> new NotFoundException("Espaço não encontrado"));

        Edition edition = this.editionRepository.findById(createActivityReq.getEditionId()).orElseThrow(() -> new NotFoundException("Edição não encontrada"));

        Activity activity = new Activity();
        activity.setName(createActivityReq.getName());
        activity.setType(createActivityReq.getType());
        activity.setDescription(createActivityReq.getDescription());
        activity.setDate(createActivityReq.getDate());
        activity.setStartTime(createActivityReq.getStartTime());
        activity.setEndTime(createActivityReq.getEndTime());
        activity.setSpace(space);
        activity.setEdition(edition);


        Activity saved = this.repository.save(activity);

        CreateActivityResp resp = new CreateActivityResp();
        resp.setId(saved.getId());
        resp.setName(saved.getName());
        resp.setType(saved.getType());
        resp.setDescription(saved.getDescription());
        resp.setDate(saved.getDate());
        resp.setStartTime(saved.getStartTime());
        resp.setEndTime(saved.getEndTime());
        resp.setSpaceId(saved.getSpace().getId());
        resp.setEditionId(saved.getEdition().getId());

        return resp;
    }

    public Activity UpdateActivity(Activity activity, Long id) {
        Activity activityToUpdate = this.repository.findById(id).get();
        activityToUpdate.setName(activity.getName());
        activityToUpdate.setDescription(activity.getDescription());
        activityToUpdate.setType(activity.getType());
        activityToUpdate.setDate(activity.getDate());
        activityToUpdate.setStartTime(activity.getStartTime());
        activityToUpdate.setEndTime(activity.getEndTime());
        activityToUpdate.setSpace(activity.getSpace());
        activityToUpdate.setEdition(activity.getEdition());
        activityToUpdate.setFavoritedByUsers(activity.getFavoritedByUsers());
        return this.repository.save(activity);
    }

    public Activity GetActivity(Long id) {
        return this.repository.findById(id).get();
    }

    public void DeleteActivity(Long id) {
        this.repository.deleteById(id);
    }
    public void FavActivity(Long activityId, Long userId) {
        Activity activity = this.repository.findById(activityId).orElseThrow(() -> new RuntimeException("Atividade não encontrada"));
        User user = this.userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!activity.getFavoritedByUsers().contains(user)) {
            activity.getFavoritedByUsers().add(user);
            user.getFavoriteActivities().add(activity);

            this.repository.save(activity);
            this.userRepository.save(user);
        }
    }

}
