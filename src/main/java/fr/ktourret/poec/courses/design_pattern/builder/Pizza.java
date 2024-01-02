package fr.ktourret.poec.courses.design_pattern.builder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Pizza { // Item

    private String base;

    private String dough;

    private String ingredients;

}
