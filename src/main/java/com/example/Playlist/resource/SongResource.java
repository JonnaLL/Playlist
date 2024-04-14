package com.example.Playlist.resource;

import com.example.Playlist.model.Song;
import com.example.Playlist.service.SongService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/song")
public class SongResource {

        private final SongService songService;

        public SongResource(SongService songService){
            this.songService = songService;
        }


        @GetMapping("/all")
        public ResponseEntity<List<Song>> getAllSongs(){
            List<Song> songs = songService.findAll();
            return new ResponseEntity<>(songs, HttpStatus.OK);
        }

        @GetMapping("find/{id}")
        public ResponseEntity<Song> getSongById(@PathVariable("id") Long id){
            Song song = songService.findSongById(id);
            return new ResponseEntity<>(song, HttpStatus.OK);
        }

        @PostMapping("/add")
        public ResponseEntity<Song> addSong(@RequestBody Song song) {
            Song newSong = songService.addSong(song);
            return new ResponseEntity<>(newSong, HttpStatus.CREATED);
        }

        @PutMapping("/update")
        public ResponseEntity<Song> updateSong(@RequestBody Song song){
            Song updateSong = songService.updateSong(song);
            return new ResponseEntity<>(updateSong, HttpStatus.OK);
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> deleteSong(@PathVariable("id") Long id){
            songService.deleteSong(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }
