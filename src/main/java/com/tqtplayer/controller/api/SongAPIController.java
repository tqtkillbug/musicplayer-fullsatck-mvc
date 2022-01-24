package com.tqtplayer.controller.api;

import com.tqtplayer.model.PlayList;
import com.tqtplayer.model.Song;
import com.tqtplayer.model.User;
import com.tqtplayer.service.IPlaylistService;
import com.tqtplayer.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/song")
public class SongAPIController {

    @Autowired
    private ISongService songService ;

    @Autowired
    private HttpSession session;



    @GetMapping("")
    public ResponseEntity<List<Song>> getAllSong(){
      List<Song> songList = songService.findAll();
      return new ResponseEntity<>(songList, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable long id){
        Song song = songService.findById(id).get();
        song.setCountListens(song.getCountListens()+1);
        songService.save(song);
        System.out.println(song);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<List<Song>> getSongListByName(@RequestParam String keySearch) {
        List<Song> songList = songService.findBySongName(keySearch);
        return new ResponseEntity<>(songList, HttpStatus.OK);
    }




}
