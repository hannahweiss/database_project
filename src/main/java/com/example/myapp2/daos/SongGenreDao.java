package com.example.myapp2.daos;

import com.example.myapp2.models.Genre;
import com.example.myapp2.models.Song;
import com.example.myapp2.models.SongGenre;
import com.example.myapp2.repositories.GenreRepository;
import com.example.myapp2.repositories.SongGenreRepository;
import com.example.myapp2.repositories.SongRepository;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongGenreDao {
  @Autowired
  SongRepository songRepository;
  @Autowired
  SongGenreRepository songGenreRepository;
  @Autowired
  GenreRepository genreRepository;

  @GetMapping("/findAllSongGenres")
  public Iterable<SongGenre> findAllSongGenres() {
    return songGenreRepository.findAll();
  }

  @GetMapping("/findGenreBySong/{songId}")
  public Optional<Genre> findGenreBySong (
      @PathVariable("songId") Integer songId) {
    Optional<Genre> genre = null;
    Iterable<SongGenre> songGenres = songGenreRepository.findAll();
    for (SongGenre sg : songGenres) {
      if (sg.getSongId() == songId) {
        int genreId = sg.getGenreId();
        genre = genreRepository.findById(genreId);
      }
    }
    return genre;
  }

  @GetMapping("/findSongsByGenre/{genreId}")
  public List<Optional<Song>> findSongsByGenre (
      @PathVariable("genreId") Integer genreId) {
    List<Optional<Song>> songs = new ArrayList<>();
    Iterable<SongGenre> songGenres = songGenreRepository.findAll();
    for (SongGenre sg : songGenres) {
      if (sg.getGenreId() == genreId) {
        Integer currentSong = sg.getSongId();
        songs.add(songRepository.findById(currentSong));
      }
    }
    return songs;
  }
}