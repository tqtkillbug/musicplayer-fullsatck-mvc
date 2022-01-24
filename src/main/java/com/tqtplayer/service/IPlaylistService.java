package com.tqtplayer.service;

import com.tqtplayer.model.PlayList;
import com.tqtplayer.model.Song;

import java.util.List;
import java.util.Optional;

public interface IPlaylistService extends IGeneralService<PlayList>{
    List<PlayList> findAllByUser_Id(long id);

    Optional<Song> findSongInplaylist(long id);
}
