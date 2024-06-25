package com.example.cmseventosapi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cmseventosapi.Model.Edition;

public interface EditionRepository extends JpaRepository<Edition, Long>{
    
}
