package fr.ktourret.poec.courses.design_pattern.composite;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class Department { // Composant

    private int nbPersonal;

    private String name;

}
