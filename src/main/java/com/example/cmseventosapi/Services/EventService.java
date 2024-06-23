package com.example.cmseventosapi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cmseventosapi.Model.Event;
import com.example.cmseventosapi.Repositories.EventRepository;

@Service
public class EventService {
    
    @Autowired
    private EventRepository repository;

    public Event CreateEvent(Event event) {
        return this.repository.save(event);
    }

    public Event UpdateEvent(Event event, Long id) {
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
        this.repository.deleteById(id);
    }
}
