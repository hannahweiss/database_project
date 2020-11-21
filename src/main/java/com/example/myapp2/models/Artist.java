package com.example.myapp2.models;

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

    public Artist(){

    }

    public Artist(Integer userId){
        this.userId = userId;
    }


}
