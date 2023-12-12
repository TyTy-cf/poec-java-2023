package fr.ktourret.poec.entity.recipe_maker;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Unit {

    GR("gr"),
    CL("cl"),
    CAS("càs"),
    CAC("càc"),
    SINGLE(""),
    PINCH("pincée");

    private final String val;

}
