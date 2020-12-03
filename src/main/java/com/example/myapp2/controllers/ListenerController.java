package com.example.myapp2.controllers;

import com.example.myapp2.models.Listener;
import com.example.myapp2.repositories.ListenerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListenerController {
    @Autowired
    ListenerRepository listenerRepository;
    @GetMapping("/api/Listeners")
    public List<Listener> findAllListeners() {
        return (List<Listener>) listenerRepository.findAll();
    }
}