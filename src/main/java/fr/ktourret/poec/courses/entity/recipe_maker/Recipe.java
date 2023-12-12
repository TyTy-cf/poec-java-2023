package fr.ktourret.poec.courses.entity.recipe_maker;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Recipe {

    private String name;

    private String description;

    private int preparationTime;

    private int cookingTime;

    private List<RecipeIngredient> recipeIngredients = new ArrayList<>();

    private List<Comment> comments = new ArrayList<>();
    
    private User owner;

    private boolean isAlcoholFree = true;

    private boolean isVegan = true;

    private boolean isVegetarian = true;

    private boolean isGlutenFree = true;

    public void addRecipeIngredient(RecipeIngredient recipeIngredient) {
        if (!recipeIngredients.contains(recipeIngredient)) {
            recipeIngredients.add(recipeIngredient);
            if (recipeIngredient.getRecipe() == null) {
                recipeIngredient.setRecipe(this);
            }
            // & supplémentaire : on stock dans isAlcoholFree sa valeur && la valeur retournée par la méthode
            // si on met dedans : true && false => alors isAlcoholFree sera false
            isAlcoholFree &= recipeIngredient.getIngredient().isAlcoholFree();
            isVegan &= recipeIngredient.getIngredient().isVegan();
            isVegetarian &= recipeIngredient.getIngredient().isVegetarian();
            isGlutenFree &= recipeIngredient.getIngredient().isGlutenFree();
        }
    }

    public void addComment(Comment comment) {
        if (!comments.contains(comment)) {
            comments.add(comment);
        }
    }

    public double getRating() {
        if (comments.isEmpty()) {
            return -1;
        }
        double rating = 0;
        for (Comment comment : comments) {
            rating += comment.getRating();
        }
        return rating / comments.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" (");
        sb.append(getName());
        sb.append(")");
        sb.append("\n");
        sb.append("isAlcoholFree : ");
        sb.append(isAlcoholFree);
        sb.append("\n");
        sb.append("isVegan : ");
        sb.append(isVegan);
        sb.append("\n");
        sb.append("isVegetarian : ");
        sb.append(isVegetarian);
        sb.append("\n");
        sb.append("isGlutenFree : ");
        sb.append(isGlutenFree);
        sb.append("\n");
        for (RecipeIngredient ri : recipeIngredients) {
            sb.append(ri);
            sb.append("\n");
        }
        return sb.toString();
    }
}
