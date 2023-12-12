package fr.ktourret.poec.courses.entity.spotifish;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class LikableItem {

    protected Long id;

    protected String name;

    protected List<User> users = new ArrayList<>();

    public void addUser(User user) {
        if (!users.contains(user)) {
            users.add(user);
            if (!user.getLikableItems().contains(this)) {
                user.addLikableItem(this);
            }
        }
    }

    public int getQtyLikes() {
        return users.size();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " (name : " + this + " ; liked : " + getQtyLikes() + " )";
    }
}
