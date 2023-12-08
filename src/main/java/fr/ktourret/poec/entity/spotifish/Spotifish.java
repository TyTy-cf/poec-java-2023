package fr.ktourret.poec.entity.spotifish;

import java.util.Date;

public class Spotifish {

    public void test() {
        User user = generateUser();
        Playlist playlist = generatePlaylist("Zuper Playlist");
        user.addPlaylist(playlist);

//        System.out.println(user);
//        System.out.println(playlist);
//        System.out.println(user.getPlaylists().size());

        Artist artist = generateArtist("ZE Toto");
        Song song = generateSong("Toto's Song", (int) getRandomBetween(40, 666));
        Song s1 = generateSong("Toto's Song 1", (int) getRandomBetween(40, 480));
        Song s2 = generateSong("Toto's Song 2", (int) getRandomBetween(40, 480));
        Song s3 = generateSong("Toto's Song 3", (int) getRandomBetween(40, 480));

        artist.addSong(song);
        artist.addSong(s1);
        artist.addSong(s2);
        artist.addSong(s3);

        System.out.println(artist);
        System.out.println(song);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        Album album = generateAlbum("TOTO'Z");
        album.addSongOrder(new SongOrder(1, album, song));
        album.addSongOrder(new SongOrder(2, album, s1));
        album.addSongOrder(new SongOrder(3, album, s2));
        album.addSongOrder(new SongOrder(4, album, s3));
        album.setArtist(artist);

        System.out.println(album);

        user.addLikableItem(artist);
        user.addLikableItem(song);
        user.addLikableItem(album);
        user.addLikableItem(playlist);

        System.out.println(user.getLikableItems());
    }

    private Playlist generatePlaylist(String name) {
        Playlist playlist = new Playlist();
        playlist.setName(name);
        playlist.setCreatedAt(new Date());
        return playlist;
    }

    private Album generateAlbum(String name) {
        Album album = new Album();
        album.setName(name);
        album.setCreatedAt(new Date());
        return album;
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

    private double getRandomBetween(int min, int max) {
        return Math.floor((Math.random() * (max - min)) + min);
    }

}
