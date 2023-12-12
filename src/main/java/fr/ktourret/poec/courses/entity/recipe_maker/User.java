package fr.ktourret.poec.courses.entity.recipe_maker;

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

    private String email;

    private String password;

    private String username;

    private Date birthedAt;

    private List<Recipe> ownedRecipes = new ArrayList<>();

    private List<Favorite> favorites = new ArrayList<>();

    private List<Comment> comments = new ArrayList<>();

    public void addRecipe(Recipe recipe) {
        if (!ownedRecipes.contains(recipe)) {
            ownedRecipes.add(recipe);
        }
    }

    public void addFavorite(Favorite favorite) {
        if (!favorites.contains(favorite)) {
            favorites.add(favorite);
        }
    }

    public void addComment(Comment comment) {
        if (!comments.contains(comment)) {
            comments.add(comment);
        }
    }

}
