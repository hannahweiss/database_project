package com.example.myapp2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name="social_medias")
public class SocialMedia {
  @Id
  @Column(name="id")
  private Integer id;

  @Column(name="type_id")
  private Integer socialMediaType;

  @Column(name="url")
  private String url;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name="artist_id", nullable=false)
  private Artist artist;

  public SocialMedia(){
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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
