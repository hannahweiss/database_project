package com.example.myapp2.daos;

import com.example.myapp2.models.Artist;
import com.example.myapp2.models.Song;
import com.example.myapp2.models.User;
import com.example.myapp2.repositories.ArtistRepository;
import com.example.myapp2.repositories.SongRepository;
import com.example.myapp2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArtistDao {
    @Autowired
    ArtistRepository artistRepository;
    @Autowired
    UserRepository userRepository;
    @GetMapping("/findAllArtists")
    public Iterable<Artist> findAllArtists() {
        return artistRepository.findAll();
    }
    @GetMapping("/findArtistByUserId/{userId}")
    public Artist findArtistByUserId(
            @PathVariable("userId") Integer userId) {
        return artistRepository.findById(userId).get();
    }
    @GetMapping("/deleteArtist/{userId}")
    public void deleteArtist(
            @PathVariable("userId") Integer userId) {
        artistRepository.deleteById(userId);
    }
    @GetMapping("/createArtist")
    public Artist createArtist() {
        User user = new User();
        userRepository.save(user);

        Integer userId = user.getId();
        Artist artist = new Artist(userId);
        artist.setBio("I'm a new artist!");
        artistRepository.save(artist);
        return artist;
    }

    @GetMapping("/updateArtistBio/{userId}/{newBio}")
    public Artist updateArtistBio(
            @PathVariable("userId") Integer userId,
            @PathVariable("newBio") String newBio) {
        Artist artist = artistRepository.findById(userId).get();
        artist.setBio(newBio);
        artistRepository.save(artist);
        return artist;
    }
}