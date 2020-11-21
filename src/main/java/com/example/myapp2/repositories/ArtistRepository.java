package com.example.myapp2.repositories;

import com.example.myapp2.models.Artist;
import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist, Integer> {
}