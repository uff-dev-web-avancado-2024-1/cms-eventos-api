package com.example.cmseventosapi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cmseventosapi.Model.Event;

public interface EventRepository extends JpaRepository<Event, Long>{
    
}
