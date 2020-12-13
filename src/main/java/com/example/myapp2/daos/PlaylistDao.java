package com.example.myapp2.daos;

import com.example.myapp2.models.Artist;
import com.example.myapp2.models.Genre;
import com.example.myapp2.models.Playlist;
import com.example.myapp2.models.Song;
import com.example.myapp2.models.SongInformation;
import com.example.myapp2.models.User;
import com.example.myapp2.repositories.GenreRepository;
import com.example.myapp2.repositories.PlaylistRepository;
import com.example.myapp2.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class PlaylistDao {
    @Autowired
    PlaylistRepository playlistRepository;
    @Autowired
    UserRepository userRepository;

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
    public Playlist updatePlaylist(
            @PathVariable("id") Integer id,
            @PathVariable("newName") String newName) {
        Playlist playlist = playlistRepository.findById(id).get();
        playlist.setName(newName);
        playlistRepository.save(playlist);
        return playlist;
    }

    @GetMapping("/getSongInformationForPlaylist/{playlistId}")
    public List<SongInformation> getSongsForPlaylist(
        @PathVariable("playlistId") Integer playlistId) {
        Playlist playlist = playlistRepository.findById(playlistId).get();
        List<SongInformation> songInfo = new ArrayList<>();
        for (Song s : playlist.getSongAdditions()) {
            List<String> artistNames = new ArrayList<>();
            List<String> genreNames = new ArrayList<>();
            Set<Artist> artists = s.getArtists();
            Set<Genre> genres = s.getGenres();
            for (Artist a : artists) {
                User currUser = userRepository.findById(a.getUserId()).get();
                artistNames.add(currUser.getFirstName() + " " + currUser.getLastName());
            }
            for (Genre g : genres) {
                genreNames.add(g.getName());
            }
            songInfo.add(new SongInformation(s, artistNames, genreNames));
        }
        return songInfo;
    }

    @PutMapping("/updatePlaylist/{playlistId}")
    public Playlist updatePlaylist(
            @PathVariable("playlistId") Integer playlistId,
            @RequestBody Playlist updatedPlaylist
    ) {
        updatedPlaylist.setId(playlistId);
        return playlistRepository.save(updatedPlaylist);
    }

    @PostMapping("/createPlaylist")
    public Playlist createPlaylist(
            @RequestBody Playlist newPlaylist
    ) {
        playlistRepository.save(newPlaylist);
        return newPlaylist;
    }

}
