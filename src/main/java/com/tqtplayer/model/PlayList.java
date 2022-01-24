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
@Table(name = "playlists")
public class PlayList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String playlistName;

    @Column(columnDefinition = "boolean default false")
    private boolean deleted;

    @ManyToOne
    @JoinColumn(name="userId")
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Song> songList;

    @Override
    public String toString() {
        return "PlayList{" +
                "id=" + id +
                ", playlistName='" + playlistName + '\'' +
                ", deleted=" + deleted +
                ", user=" + user +
                ", songList=" + songList +
                '}';
    }
}
