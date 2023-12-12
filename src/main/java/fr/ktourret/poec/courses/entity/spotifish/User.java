package fr.ktourret.poec.courses.entity.spotifish;

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
public class User {

    private Long id;

    private String email;

    private String username;

    private String firstName;

    private String lastName;

    private Date birthedAt;

    private List<Playlist> playlists = new ArrayList<>();

    private List<UserSubscription> userSubscriptions = new ArrayList<>();

    private List<LikableItem> likableItems = new ArrayList<>();

    public void addPlaylist(Playlist playlist) {
        if (!playlists.contains(playlist)) {
            playlists.add(playlist);
            playlist.setOwner(this);
        }
    }

    public void addLikableItem(LikableItem likableItem) {
        if (!likableItems.contains(likableItem)) {
            likableItems.add(likableItem);
            if (!likableItem.getUsers().contains(this)) {
                likableItem.addUser(this);
            }
        }
    }

    public void addUserSubscription(UserSubscription userSubscription) {
        if (!userSubscriptions.contains(userSubscription)) {
            userSubscriptions.add(userSubscription);
            userSubscription.setUser(this);
        }
    }

    @Override
    public String toString() {
        return "User(username : " + username + "; email : " + email + ")";
    }

}
