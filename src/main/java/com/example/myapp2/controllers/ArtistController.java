package com.example.myapp2.controllers;

import com.example.myapp2.models.Artist;
import com.example.myapp2.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArtistController {
    @Autowired
    ArtistRepository artistRepository;
    @GetMapping("/api/Artists")
    public List<Artist> findAllArtists() {
        return (List<Artist>) artistRepository.findAll();
    }
}
