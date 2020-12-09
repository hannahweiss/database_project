package com.example.myapp2.repositories;

import com.example.myapp2.models.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Integer> {

}

