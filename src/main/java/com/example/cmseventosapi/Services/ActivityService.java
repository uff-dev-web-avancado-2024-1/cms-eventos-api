package com.example.cmseventosapi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cmseventosapi.Model.Activity;
import com.example.cmseventosapi.Repositories.ActivityRepository;

@Service
public class ActivityService {
    
    @Autowired
    private ActivityRepository repository;

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

}
