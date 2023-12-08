package fr.ktourret.poec.entity.spotifish;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Artist extends LikableItem {

    private Date beganAt;

    private String description;

    private String image;

    private List<Album> albumList = new ArrayList<>();

    private List<Song> songList = new ArrayList<>();

    public void addAlbum(Album album) {
        if (!albumList.contains(album)) {
            albumList.add(album);
            album.setArtist(this);
        }
    }

    public void addSong(Song song) {
        if (!songList.contains(song)) {
            songList.add(song);
            song.setArtist(this);
        }
    }

    @Override
    public String toString() {
        return "Artist(name : " + name + "; songs : " + songList.size() + ")";
    }

}
