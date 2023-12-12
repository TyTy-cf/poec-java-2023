package fr.ktourret.poec.entity.recipe_maker;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RecipeIngredient {

    private Ingredient ingredient;

    private Recipe recipe;

    private Unit unit;

    private int qty;

    public RecipeIngredient(Ingredient ingredient, Unit unit, int qty) {
        this.ingredient = ingredient;
        this.unit = unit;
        this.qty = qty;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RecipeIngredient (");
        sb.append(qty);
        sb.append(unit);
        sb.append(" ");
        sb.append(ingredient.getName());
        sb.append(")");
        return sb.toString();
    }
}
