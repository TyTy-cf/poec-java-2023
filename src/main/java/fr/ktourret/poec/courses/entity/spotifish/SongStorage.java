package fr.ktourret.poec.courses.entity.spotifish;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(getClass().getSimpleName());
        sb.append(" ( name : ");
        sb.append(name);
        if (this instanceof Album) {
            sb.append(" ; artist : ");
            sb.append(((Album) this).getArtist());
        } else if (this instanceof Playlist) {
            sb.append(" ; propriétaire : ");
            sb.append(((Playlist) this).getOwner());
        }
        sb.append(" ; durée : ");
        sb.append(getDuration());
        sb.append(" )");
        sb.append("\n");
        for (SongOrder so : songOrderList) {
            sb.append(so);
            sb.append("\n");
        }
        return sb.toString();
    }

}
