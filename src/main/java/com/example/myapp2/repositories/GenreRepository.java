package com.example.myapp2.repositories;

import com.example.myapp2.models.Genre;
import com.example.myapp2.models.SongGenre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Integer> {

}

