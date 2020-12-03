package com.example.myapp2.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="Playlists")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="created_by")
    private Integer createdBy;

    @Column(name="name")
    private String name;

    @Column(name="created_at")
    private LocalDate createdAt;

    public Playlist(){

    }

    public Playlist(Integer createdBy){
        this.createdBy = createdBy;
        this.createdAt = LocalDate.now();
    }

    public Playlist(Integer createdBy, String name){
        this.createdBy = createdBy;
        this.createdAt = LocalDate.now();
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

}
