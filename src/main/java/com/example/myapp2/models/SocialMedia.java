package com.example.myapp2.models;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="social_medias")
public class SocialMedia {
  @Id
  @Column(name="id")
  private Integer id;

  @Column(name="artist_id")
  private Integer artistId;

  @Column(name="type_id")
  private Integer socialMediaType;

  @Column(name="url")
  private String url;

  public SocialMedia(){
  }

  public SocialMedia(Integer id, Integer artistId, Integer socialMediaType, String url) {
    this.id = id;
    this.artistId = artistId;
    this.socialMediaType = socialMediaType;
    this.url = url;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getArtistId() {
    return artistId;
  }

  public void setArtistId(Integer artistId) {
    this.artistId = artistId;
  }

  public Integer getSocialMediaType() {
    return socialMediaType;
  }

  public void setSocialMediaType(Integer socialMediaType) {
    this.socialMediaType = socialMediaType;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
