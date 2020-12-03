package com.example.myapp2.daos;

import com.example.myapp2.models.Playlist;
import com.example.myapp2.repositories.PlaylistRepository;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaylistDao {
    @Autowired
    PlaylistRepository playlistRepository;
    @GetMapping("/findAllPlaylists")
    public Iterable<Playlist> findAllPlaylists() {
        return playlistRepository.findAll();
    }
    @GetMapping("/findPlaylistById/{id}")
    public Playlist findPlaylistById(
            @PathVariable("id") Integer id) {
        return playlistRepository.findById(id).get();
    }
    @GetMapping("/deletePlaylist/{id}")
    public void deletePlaylist(
            @PathVariable("id") Integer id) {
        playlistRepository.deleteById(id);
    }
    @GetMapping("/createPlaylist/{userId}")
    public Playlist createPlaylist(
            @PathVariable("userId") Integer userId) {
        Playlist playlist = new Playlist(userId);
        playlistRepository.save(playlist);
        return playlist;
    }

    @GetMapping("/updatePlaylistName/{id}/{newName}")
    public Playlist createPlaylist(
            @PathVariable("id") Integer id,
            @PathVariable("newName") String newName) {
        Playlist playlist = playlistRepository.findById(id).get();
        playlist.setName(newName);
        playlistRepository.save(playlist);
        return playlist;
    }

}
