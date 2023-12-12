package fr.ktourret.poec.courses.entity.spotifish;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Playlist extends SongStorage {

    private User owner;

    @Override
    public String toString() {
        return "Playlist(nom : " + name + "; owner : " + owner.getUsername() + ")";
    }
}
