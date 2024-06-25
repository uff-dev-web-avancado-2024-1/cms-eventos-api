package com.example.cmseventosapi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cmseventosapi.Model.Message;

public interface MessageRepository extends JpaRepository<Message, Long>{
    
}
