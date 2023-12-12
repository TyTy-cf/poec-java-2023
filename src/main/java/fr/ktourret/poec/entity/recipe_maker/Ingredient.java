package fr.ktourret.poec.entity.recipe_maker;

import fr.ktourret.poec.entity.bank.Operation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ingredient {

    private String name;

    private List<IngredientType> ingredientTypes = new ArrayList<>();

    public void addIngredientType(IngredientType ingredientType) {
        if (!ingredientTypes.contains(ingredientType)) {
            ingredientTypes.add(ingredientType);
        }
    }

    public boolean isAlcoholFree() {
        return !ingredientTypes.contains(IngredientType.HAS_ALCOHOL);
    }

    public boolean isVegan() {
        return !ingredientTypes.contains(IngredientType.NOT_VEGAN);
    }

    public boolean isVegetarian() {
        return !ingredientTypes.contains(IngredientType.NOT_VEGETARIAN);
    }

    public boolean isGlutenFree() {
        return !ingredientTypes.contains(IngredientType.HAS_GLUTEN);
    }

}
