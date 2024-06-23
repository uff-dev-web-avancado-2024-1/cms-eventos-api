package com.example.cmseventosapi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cmseventosapi.Model.Space;
import com.example.cmseventosapi.Repositories.SpaceRepository;

@Service
public class SpaceService {
    
    @Autowired
    private SpaceRepository repository;

    public Space CreateSpace(Space space) {
        return this.repository.save(space);
    }

    public Space UpdateSpace(Space space, Long id) {
        Space spaceToUpdate = this.repository.findById(id).get();
        spaceToUpdate.setName(space.getName());
        spaceToUpdate.setCapacity(space.getCapacity());
        spaceToUpdate.setResources(space.getResources());
        return this.repository.save(space);
    }

    public Space GetSpace(Long id) {
        return this.repository.findById(id).get();
    }

    public void DeleteSpace(Long id) {
        this.repository.deleteById(id);
    }

}
