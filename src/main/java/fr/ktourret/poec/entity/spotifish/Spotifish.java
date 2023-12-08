package fr.ktourret.poec.entity.spotifish;

import java.util.Date;

public class Spotifish {

    public void test() {
        User user = generateUser();
        System.out.println(user);

        Playlist playlist = generatePlaylist("Zuper Playlist");

        user.addPlaylist(playlist);

        System.out.println(playlist);
        System.out.println(user.getPlaylists().size());

        Artist artist = generateArtist("Toto");
        Song song = generateSong("Toto's Song", 666);

        artist.addSong(song);

        System.out.println(artist);
        System.out.println(song);
    }

    private Playlist generatePlaylist(String name) {
        Playlist playlist = new Playlist();
        playlist.setName(name);
        playlist.setCreatedAt(new Date());
        return playlist;
    }

    private Artist generateArtist(String name) {
        Artist artist = new Artist();
        artist.setName(name);
        return artist;
    }

    private Song generateSong(String name, int duration) {
        Song song = new Song();
        song.setName(name);
        song.setDuration(duration);
        return song;
    }

    private User generateUser() {
        User user = new User();
        user.setId(1L);
        user.setFirstName("Toto");
        user.setLastName("TOTO");
        user.setEmail("toto@toto.com");
        user.setUsername("Toto=0");
        // setter pour les attributs du user
        return user;
    }

}
