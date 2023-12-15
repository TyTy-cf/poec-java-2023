package fr.ktourret.poec.my_mvc.entity.instant_faking;

import fr.ktourret.poec.my_mvc.entity.EntityInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Category implements EntityInterface {

    private Long id;

    private String name;

    private String image;

    private String slug;

}