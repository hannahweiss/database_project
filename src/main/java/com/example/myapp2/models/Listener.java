package com.example.myapp2.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;


@Entity
@Table(name="Listeners")
public class Listener {
    @Id
    @Column(name="user_id")
    private Integer userId;

    @Column(name="date_joined")
    private LocalDate dateJoined;

    public Listener(){
    }

    public Listener(Integer userId){
        this.userId = userId;
        this.dateJoined = LocalDate.now();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDate getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(LocalDate dateJoined) {
        this.dateJoined = dateJoined;
    }
}
