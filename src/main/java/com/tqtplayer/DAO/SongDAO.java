package com.tqtplayer.DAO;

import com.tqtplayer.connection.MysqlConnection;
import com.tqtplayer.model.Song;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SongDAO implements ISongDAO {


    private static final String INSERT_SONG_SQL = "INSERT INTO songs (songName,singerName,songPath,logoPath,deleted,countListens) VALUES (?, ?,?,?,?,?);";
    private static final String SELECT_ALL_SONG = "select * from songs";
    private static final String DELETE_SONG_SQL = "delete from songs where id = ?;";
    private static final String SELECT_COUNT_SONG_SQL = "SELECT COUNT(id) FROM songs ";
    private static final String UPDATE_SONG_SQL = "update songs set songname = ?,singername= ? ,status= ? where id = ?;";

    public SongDAO(){
        MysqlConnection.init("tqt-player-ajax-mvc");
    }

    @Override
    public List<Song> selectAllSong(){
        List<Song> songs = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = MysqlConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SONG);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("id");
                String songName = rs.getString("songName");
                String singerName = rs.getString("singerName");
                String songPath = rs.getString("songPath");
                String logoPath = rs.getString("logoPath");
                int deletedNum = rs.getInt("deleted");
                boolean deleted;
                if (deletedNum == 0){
                    deleted = false;
                } else{
                    deleted = true;
                }
                long countListens = rs.getLong("countListens");
                songs.add(new Song(id,songName,singerName,songPath,logoPath, deleted,countListens));
            }
        } catch (SQLException ignored) {
        }
        return songs;
    }
    @Override
    public int getCount(){
        int rows = 0;
        try (Connection connection = MysqlConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COUNT_SONG_SQL);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                rows = rs.getInt("count(id)");
            }
        } catch (SQLException ignored) {
        }
        return rows;
    }
    @Override
    public void insertSong(Song newSong){
        System.out.println(INSERT_SONG_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = MysqlConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SONG_SQL)) {
            preparedStatement.setString(1, newSong.getSongName());
            preparedStatement.setString(2, newSong.getSingerName());
            preparedStatement.setString(3, newSong.getSongPath());
            preparedStatement.setString(4, newSong.getLogoPath());
            preparedStatement.setLong(5, 0);
            preparedStatement.setLong(6, 0);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ignored) {
        }
    }
    @Override
    public boolean updateSong(Song song) throws SQLException {
        boolean rowUpdated = false;
//        try (Connection connection = MysqlConnection.getInstance().getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_SONG_SQL);) {
//            statement.setString(1, song.getSongName());
//            statement.setString(2, song.getSingerName());
//            statement.setString(3, song.getStatus());
//            statement.setInt(4, song.getId());
//
//            rowUpdated = statement.executeUpdate() > 0;
//        }
        return rowUpdated;
    }
    @Override
    public boolean deleteSong(int id) throws SQLException {
        boolean rowDeleted = false;
//        try (Connection connection = MysqlConnection.getInstance().getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_SONG_SQL);) {
//            statement.setInt(1, id);
//            rowDeleted = statement.executeUpdate() > 0;
//        }
        return rowDeleted;
    }
}
