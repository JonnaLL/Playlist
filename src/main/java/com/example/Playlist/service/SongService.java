package com.example.Playlist.service;

import com.example.Playlist.exception.SongNotFoundException;
import com.example.Playlist.model.Song;
import com.example.Playlist.repo.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class SongService {
    private final SongRepo songRepo;

    @Autowired
    public SongService(SongRepo songRepo) {
        this.songRepo = songRepo;
    }

    public Song addSong(Song song) {
        return songRepo.save(song);
    }

    public List<Song> findAll() {
        return songRepo.findAll();
    }

    public Song updateSong(Song song) {
        return songRepo.save(song);
    }

    public Song findSongById(Long id) {
        return songRepo.findSongById(id).orElseThrow(
                () -> new SongNotFoundException("Song by id " + id + " was not found")
        );
    }

    public void deleteSong(Long id) {
        songRepo.deleteSongById(id);
    }

}
