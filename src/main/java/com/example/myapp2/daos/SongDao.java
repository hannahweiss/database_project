package com.example.myapp2.daos;

import com.example.myapp2.models.Artist;
import com.example.myapp2.models.Song;
import com.example.myapp2.repositories.ArtistRepository;
import com.example.myapp2.repositories.SongRepository;
import com.example.myapp2.repositories.UserRepository;
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
}
