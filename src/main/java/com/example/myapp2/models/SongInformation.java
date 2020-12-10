package com.example.myapp2.models;
import java.util.List;

public class SongInformation {
    private Song song;
    private List<String> artistNames;
    private List<String> genreNames;


    public SongInformation(Song song, List<String> artistNames, List<String> genreNames) {
        this.song = song;
        this.artistNames = artistNames;
        this.genreNames = genreNames;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public List<String> getArtistNames() {
        return artistNames;
    }

    public void setArtistNames(List<String> artistNames) {
        this.artistNames = artistNames;
    }

    public List<String> getGenreNames() {
        return genreNames;
    }

    public void setGenreNames(List<String> genreNames) {
        this.genreNames = genreNames;
    }
}


