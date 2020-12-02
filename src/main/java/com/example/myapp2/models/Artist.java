package com.example.myapp2.models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name="Artists")
public class Artist {
    @Id
    @Column(name="user_id")
    private Integer userId;
    @Column(name="bio")
    private String bio;

    @ManyToMany
    @JoinTable(
        name = "recordings",
        joinColumns = @JoinColumn(name = "artist_id"),
        inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    private Set<Song> songRecordings;

    public Artist(){
        this.songRecordings = new HashSet<Song>();
    }

    public Artist(Integer userId){
        this.userId = userId;
        this.songRecordings = new HashSet<Song>();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Set<Song> getSongRecordings() {
        return songRecordings;
    }

    public void setSongRecordings(Set<Song> songRecordings) {
        this.songRecordings = songRecordings;
    }
}
