package fr.ktourret.poec.my_mvc.entity.instant_faking;

import fr.ktourret.poec.my_mvc.entity.EntityInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Publisher implements EntityInterface {

    private Long id;

    private Date createdAt;

    private String name;

    private String website;

    private String slug;

    private Country country;

}