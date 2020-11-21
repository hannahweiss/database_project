package com.example.myapp2.repositories;

import com.example.myapp2.models.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Integer> {
}
