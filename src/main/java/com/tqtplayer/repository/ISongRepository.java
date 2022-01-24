package com.tqtplayer.repository;

import com.tqtplayer.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISongRepository extends JpaRepository<Song,Long> {
    List<Song> findBySongNameContaining(String songName);
 }
