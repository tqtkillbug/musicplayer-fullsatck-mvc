package com.tqtplayer.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String songName;

    private String singerName;

    private String songPath;

    private String logoPath;

    @Column(columnDefinition = "boolean default false")
    private boolean deleted;

    private long countListens;





    public Song(String songName, String singerName, String songPath, String logoPath, boolean deleted, long countListens) {
        this.songName = songName;
        this.singerName = singerName;
        this.songPath = songPath;
        this.logoPath = logoPath;
        this.deleted = deleted;
        this.countListens = countListens;
    }

    public Song(long id, String songName, String singerName, String songPath, String logoPath, boolean deleted, long countListens) {
       this.id = id;
        this.songName = songName;
        this.singerName = singerName;
        this.songPath = songPath;
        this.logoPath = logoPath;
        this.deleted = deleted;
        this.countListens = countListens;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", songName='" + songName + '\'' +
                ", singerName='" + singerName + '\'' +
                ", songPath='" + songPath + '\'' +
                ", logoPath='" + logoPath + '\'' +
                ", deleted=" + deleted +
                ", countListens=" + countListens +
                '}';
    }
}
