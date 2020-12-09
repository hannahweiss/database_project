package com.example.myapp2.daos;

import antlr.ASTNULLType;
import com.example.myapp2.models.Artist;
import com.example.myapp2.models.Genre;
import com.example.myapp2.models.Playlist;
import com.example.myapp2.models.Song;
import com.example.myapp2.models.User;
import com.example.myapp2.repositories.ArtistRepository;
import com.example.myapp2.repositories.GenreRepository;
import com.example.myapp2.repositories.PlaylistRepository;
import com.example.myapp2.repositories.SongRepository;
import com.example.myapp2.repositories.UserRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongDao {
    @Autowired
    SongRepository songRepository;
    @Autowired
    ArtistRepository artistRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PlaylistRepository playlistRepository;
    @Autowired
    GenreRepository genreRepository;

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

    @GetMapping("/createSong/{artistId}/{songName}")
    public Song createSong(
        @PathVariable("artistId") Integer artistId,
        @PathVariable("songName") String songName) {
        Song song = new Song();
        song.setName(songName);

        Set<Artist> artists = song.getArtists();
        Artist currentArtist = artistRepository.findById(artistId).get();
        artists.add(currentArtist);
        song.setArtists(artists);

        songRepository.save(song);

        Set<Song> recordings = currentArtist.getSongRecordings();
        recordings.add(song);
        currentArtist.setSongRecordings(recordings);

        artistRepository.save(currentArtist);

        return song;
    }

    @GetMapping("/addSongToPlaylist/{playlistId}/{songId}")
    public Playlist addSongToPlaylist(
            @PathVariable("playlistId") Integer playlistId,
            @PathVariable("songId") Integer songId) {
        Song song = songRepository.findById(songId).get();

        Set<Playlist> playlists = song.getPlaylists();
        Playlist currentPlaylist = playlistRepository.findById(playlistId).get();
        playlists.add(currentPlaylist);
        song.setPlaylists(playlists);

        songRepository.save(song);

        Set<Song> songAdditions = currentPlaylist.getSongAdditions();
        songAdditions.add(song);
        currentPlaylist.setSongAdditions(songAdditions);

        playlistRepository.save(currentPlaylist);

        return currentPlaylist;
    }

    @GetMapping("/findArtistsBySong/{songId}")
    public Set<User> findArtistsBySong(
        @PathVariable("songId") Integer songId) {
        Song song = songRepository.findById(songId).get();
        Set<Artist> artists = song.getArtists();
        Set<User> users = new HashSet<>();
        for (Artist artist : artists){
            int userId = artist.getUserId();
            User user = userRepository.findById(userId).get();
            users.add(user);
        }
        return users;
    }

    @GetMapping("/findGenresBySong/{songId}")
    public Set<Genre> findGenreBySong (
        @PathVariable("songId") Integer songId) {
        Song song = songRepository.findById(songId).get();
        return song.getGenres();
    }

    @GetMapping("/findSongsByGenre/{genreId}")
    public List<Song> findSongsByGenre (
        @PathVariable("genreId") Integer genreId) {
        List<Song> songs = new ArrayList<>();
        Iterable<Song> allSongs = songRepository.findAll();
        for (Song s : allSongs) {
            for (Genre g : s.getGenres()) {
                if (g.getId() == genreId) {
                    songs.add(s);
                }
            }
        }
        return songs;
    }
}
