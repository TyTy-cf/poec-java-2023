package fr.ktourret.poec.exam.entity.geogouv;

import fr.ktourret.poec.exam.entity.EntityInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Department implements EntityInterface {

    private Long id;

    private String name;

    private String code;

    private Region region;

}