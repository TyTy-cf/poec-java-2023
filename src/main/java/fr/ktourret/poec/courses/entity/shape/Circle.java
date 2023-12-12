package fr.ktourret.poec.courses.entity.shape;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Circle extends AbstractShape {

    private double radius;

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

}
