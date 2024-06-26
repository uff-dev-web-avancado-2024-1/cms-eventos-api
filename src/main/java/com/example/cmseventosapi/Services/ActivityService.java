package com.example.cmseventosapi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cmseventosapi.Model.Activity;
import com.example.cmseventosapi.Model.User;
import com.example.cmseventosapi.Repositories.ActivityRepository;
import com.example.cmseventosapi.Repositories.UserRepository;

@Service
public class ActivityService {
    
    @Autowired
    private ActivityRepository repository;

    @Autowired
    private UserRepository userRepository;

    public Activity CreateActivity(Activity activity) {
        return this.repository.save(activity);
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
