package com.tqtplayer.service;

import com.tqtplayer.model.Song;
import com.tqtplayer.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class SongService implements ISongService{

    @Autowired
    private ISongRepository songRepository;

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Optional<Song> findById(long id) {
        return songRepository.findById(id);
    }

    @Override
    public List<Song> findBySongName(String name){
        return songRepository.findBySongNameContaining(name);
    }

    @Override
    public Song getById(long id) {
        return songRepository.getById(id);
    }

    @Override
    public Song save(Song song) {
        return songRepository.save(song);
    }

    @Override
    public void remove(long id) {

    }
}
