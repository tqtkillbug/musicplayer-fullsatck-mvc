package com.tqtplayer.service;

import com.tqtplayer.model.PlayList;
import com.tqtplayer.model.Song;
import com.tqtplayer.repository.IPlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PlaylistService implements IPlaylistService {

    @Autowired
    private IPlaylistRepository playlistRepository;


    @Override
    public List<PlayList> findAll() {
        return playlistRepository.findAll();
    }

    @Override
    public Optional<PlayList> findById(long id) {
        return playlistRepository.findById(id);
    }

    @Override
    public List<PlayList> findAllByUser_Id(long id) {
        return playlistRepository.findAllByUser_Id(id);
    }

    @Override
    public PlayList getById(long id) {
        return playlistRepository.getById(id);
    }

    @Override
    public PlayList save(PlayList playList) {
        return playlistRepository.save(playList);
    }

    @Override
    public void remove(long id) {
        playlistRepository.deleteById(id);
    }
    @Override
    public Optional<Song> findSongInplaylist(long id){
        return playlistRepository.findSongInPlaylistById(id);
    }
}
