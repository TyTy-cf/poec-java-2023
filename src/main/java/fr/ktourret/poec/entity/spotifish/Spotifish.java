package fr.ktourret.poec.entity.spotifish;

import java.util.Date;

public class Spotifish {

    public void test() {
        User user = generateUser();
        System.out.println(user);

        Playlist playlist  = generatePlaylist();
        playlist.setName("My Best TOTO PLAYLIST");
        playlist.setCreatedAt(new Date());

        user.addPlaylist(playlist);

        System.out.println(playlist);
        System.out.println(user.getPlaylists().size());
    }

    private Playlist generatePlaylist() {
        return new Playlist();
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
