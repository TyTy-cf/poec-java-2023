package fr.ktourret.poec.entity.spotifish;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SongOrder {

    private int order;

    private SongStorage songStorage;

    private Song song;

    @Override
    public String toString() {
        return "SongOrder (position : " + order + " + song : " + song + " ; SongStorage : " + songStorage.getName() + " )";
    }

}
