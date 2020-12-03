package com.example.myapp2.controllers;

import com.example.myapp2.models.Playlist;
import com.example.myapp2.repositories.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlaylistController {
    @Autowired
    PlaylistRepository playlistRepository;
    @GetMapping("/api/Playlists")
    public List<Playlist> findAllPlaylists() {
        return (List<Playlist>) playlistRepository.findAll();
    }
}