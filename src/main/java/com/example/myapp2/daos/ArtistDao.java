package com.example.myapp2.daos;

import com.example.myapp2.models.*;
import com.example.myapp2.repositories.ArtistRepository;
import com.example.myapp2.repositories.SocialMediaRepository;
import com.example.myapp2.repositories.SongRepository;
import com.example.myapp2.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class ArtistDao {
    @Autowired
    ArtistRepository artistRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    SocialMediaRepository socialMediaRepository;
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

    @GetMapping("/findAllRecordings/{artistId}")
    public Set<Song> findAllRecordings(
            @PathVariable("artistId") Integer artistId) {
        Artist artist = artistRepository.findById(artistId).get();
        Set<Song> songRecordings =  artist.getSongRecordings();
        return songRecordings;
    }

    @GetMapping("/findArtistsInformation")
    public List<ArtistInformation> findArtistsInformation(){
        List<ArtistInformation> informations = new ArrayList<>();

        Iterable<Artist> artists = findAllArtists();
        for (Artist a : artists){
            int userId = a.getUserId();
            User u = userRepository.findById(userId).get();
            String artistName = (u.getFirstName() + " " + u.getLastName());

            ArtistInformation info = new ArtistInformation(a, artistName);
            informations.add(info);
        }
        return informations;
    }

}
