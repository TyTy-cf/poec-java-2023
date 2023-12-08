package fr.ktourret.poec.entity.spotifish;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class SongStorage extends LikableItem {

    protected Date createdAt;

    protected List<SongOrder> songOrderList = new LinkedList<>();

    public int getDuration() {
        int duration = 0;
        for (SongOrder so : songOrderList) {
            duration += so.getSong().getDuration();
        }
        return duration;
    }

    public void addSongOrder(SongOrder songOrder) {
        if (!songOrderList.contains(songOrder)) {
            songOrderList.add(songOrder);
            songOrder.setSongStorage(this);
        }
    }

}
