package com.example.myapp2.models;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="duration_in_seconds")
    private Integer duration;

    @ManyToMany(mappedBy = "songRecordings")
    private Set<Artist> artists;

    public Song(){
        this.artists = new HashSet<Artist>();
    }

    public Song(Integer id, String name, Integer duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.artists = new HashSet<Artist>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Set<Artist> getArtists() {
        return artists;
    }

    public void setArtists(Set<Artist> artists) {
        this.artists = artists;
    }
}
