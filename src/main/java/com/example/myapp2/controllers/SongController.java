package com.example.myapp2.controllers;

import com.example.myapp2.models.Song;
import com.example.myapp2.models.User;
import com.example.myapp2.repositories.SongRepository;
import com.example.myapp2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SongController {
    @Autowired
    SongRepository songRepository;
    @GetMapping("/api/songs")
    public List<Song> findAllSongs() {
        return (List<Song>) songRepository.findAll();
    }
}
