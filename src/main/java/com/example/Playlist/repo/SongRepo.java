package com.example.Playlist.repo;

import com.example.Playlist.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SongRepo extends JpaRepository<Song, Long> {
    void deleteSongById(Long id);

    Optional<Song> findSongById(Long id);

}
