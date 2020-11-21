package com.example.myapp2.daos;

import com.example.myapp2.models.Song;
import com.example.myapp2.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongDao {
    @Autowired
    SongRepository songRepository;
    @GetMapping("/findAllSongs")
    public Iterable<Song> findAllSongs() {
        return songRepository.findAll();
    }
    @GetMapping("/findSongById/{id}")
    public Song findSongById(
            @PathVariable("id") Integer id) {
        return songRepository.findById(id).get();
    }
    @GetMapping("/deleteSong/{id}")
    public void deleteSong(
            @PathVariable("id") Integer id) {
        songRepository.deleteById(id);
    }
    @GetMapping("/createSong")
    public Song createSong() {
        Song song = new Song();
        song.setName("new_song");
        songRepository.save(song);
        return song;
    }
}
