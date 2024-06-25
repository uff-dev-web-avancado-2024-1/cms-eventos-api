package com.example.cmseventosapi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cmseventosapi.Model.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long>{
    
}
