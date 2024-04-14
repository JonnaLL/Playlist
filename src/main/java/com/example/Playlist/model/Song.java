package com.example.Playlist.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
public class Song implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long id;

    private String songTitle;
    private String artist;
    private String genre;

    //@Column(nullable = false, updatable = false)
    //private String songCode;

    public Song(String songTitle, String artist, String genre) {
        this.songTitle = songTitle;
        this.artist = artist;
        this.genre = genre;
        //this.songCode = songCode;
    }

    public Song() {
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", songTitle='" + songTitle + '\'' +
                ", artist='" + artist + '\'' +
                ", genre='" + genre +
                '}';
    }
}
