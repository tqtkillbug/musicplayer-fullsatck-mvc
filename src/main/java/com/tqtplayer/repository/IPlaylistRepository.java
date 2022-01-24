package com.tqtplayer.repository;

import com.tqtplayer.model.PlayList;
import com.tqtplayer.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPlaylistRepository extends JpaRepository<PlayList, Long> {
    List<PlayList> findAllByUser_Id(long id);

    Optional<Song> findSongInPlaylistById(long id);
}
