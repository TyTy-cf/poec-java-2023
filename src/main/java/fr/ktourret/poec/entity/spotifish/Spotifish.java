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
    }

    private Playlist generatePlaylist(String name) {
        Playlist playlist = new Playlist();
        playlist.setName(name);
        playlist.setCreatedAt(new Date());
        return playlist;
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
