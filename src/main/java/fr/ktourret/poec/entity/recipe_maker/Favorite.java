package fr.ktourret.poec.entity.recipe_maker;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Favorite {

    private User user;

    private Recipe recipe;

    private Date createdAt;

}
