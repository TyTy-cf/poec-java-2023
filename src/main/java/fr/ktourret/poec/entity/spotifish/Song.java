package fr.ktourret.poec.entity.spotifish;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Song extends LikableItem {

    private int duration;

    private Artist artist;

    @Override
    public String toString() {
        return "Song(name : " + name + " ; durée : " + duration + " ; artist : " + artist.name + ")";
    }

}
