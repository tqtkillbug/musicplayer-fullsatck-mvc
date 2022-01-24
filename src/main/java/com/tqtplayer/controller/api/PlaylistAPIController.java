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
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/playlist")
public class PlaylistAPIController {

    @Autowired
    private IPlaylistService playlistService;

    @Autowired
    private ISongService songService;

    @Autowired
    private HttpSession session;

    @PostMapping("/create")
    public ResponseEntity<PlayList> createPlaylist(@RequestBody PlayList playList) {
        ArrayList<Song> songList = new ArrayList<>();
        User user = (User) session.getAttribute("userLogin");
        playList.setUser(user);
        playList.setSongList(songList);
        playlistService.save(playList);
        return new ResponseEntity<>(playList, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<PlayList>> getAllSong() {
        List<PlayList> playLists = playlistService.findAll();
        return new ResponseEntity<>(playLists, HttpStatus.OK);
    }

    @GetMapping("/getPlaylist")
    public ResponseEntity<List<PlayList>> getAllPlaylist() {
        List<PlayList> playLists = null;
        User user = (User) session.getAttribute("userLogin");
        playLists = playlistService.findAllByUser_Id(user.getId());
        return new ResponseEntity<>(playLists, HttpStatus.OK);
    }

    @PostMapping("/addSongToPlaylist")
    public ResponseEntity<PlayList> addSongToPlaylist(@RequestParam long songId, long playlistId) {
        Song song = songService.findById(songId).get();
        PlayList playList = playlistService.findById(playlistId).get();
        playList.getSongList().add(song);
        playlistService.save(playList);
        return new ResponseEntity<>(playList, HttpStatus.OK);
    }



    @GetMapping("/get/{playListId}")
    public ResponseEntity<List<Song>> getSongFromPlayList(@PathVariable long playListId) {
        PlayList playList = playlistService.findById(playListId).get();
        List<Song> songList = playList.getSongList();
        return new ResponseEntity<>(songList, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public void deletePlaylist(@PathVariable long id){
        playlistService.remove(id);
    }

}
