package fr.ktourret.poec.entity.recipe_maker;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum IngredientType {

    NOT_VEGAN("Not vegan"),
    NOT_VEGETARIAN("Not vegetarian"),
    HAS_GLUTEN("Has gluten"),
    HAS_ALCOHOL("Has alcohol");

    private final String type;
}
