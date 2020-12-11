package com.example.myapp2.models;

public class ArtistInformation {
    private Artist artist;
    private String name;

    public ArtistInformation(Artist artist, String name) {
        this.artist = artist;
        this.name = name;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
