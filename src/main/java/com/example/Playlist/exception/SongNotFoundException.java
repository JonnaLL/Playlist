package com.example.Playlist.exception;

public class SongNotFoundException extends RuntimeException{

    public SongNotFoundException(String message){
        super(message);
    }

}
