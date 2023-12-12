package fr.ktourret.poec.entity.recipe_maker;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Comment {

    private User user;

    private Recipe recipe;

    private String content;

    private Date createdAt;

    private double rating;

}
