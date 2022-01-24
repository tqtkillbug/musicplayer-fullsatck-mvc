package com.tqtplayer.service;

import com.tqtplayer.model.Song;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISongService extends IGeneralService<Song>{
    List<Song> findBySongName(String name);
}
