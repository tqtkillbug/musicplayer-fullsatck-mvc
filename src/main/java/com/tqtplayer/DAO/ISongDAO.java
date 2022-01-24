package com.tqtplayer.DAO;

import com.tqtplayer.model.Song;

import java.sql.SQLException;
import java.util.List;

public interface ISongDAO {
    List<Song> selectAllSong();


    int  getCount();

    void insertSong(Song newSong);

    boolean updateSong(Song song) throws SQLException;

    boolean deleteSong(int id) throws SQLException;
}