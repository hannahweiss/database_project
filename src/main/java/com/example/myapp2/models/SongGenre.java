package com.example.myapp2.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="song_genres")
public class SongGenre {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  private Integer id;
  @Column(name="song_id")
  private Integer songId;

  @Column(name="genre_id")
  private Integer genreId;

  public SongGenre() {
  }

  public SongGenre(Integer id, Integer songId, Integer genreId) {
    this.id = id;
    this.songId = songId;
    this.genreId = genreId;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getSongId() {
    return songId;
  }

  public void setSongId(Integer songId) {
    this.songId = songId;
  }

  public Integer getGenreId() {
    return genreId;
  }

  public void setGenreId(Integer genreId) {
    this.genreId = genreId;
  }
}
