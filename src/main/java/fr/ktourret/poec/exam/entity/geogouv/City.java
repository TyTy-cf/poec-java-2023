package fr.ktourret.poec.exam.entity.geogouv;

import fr.ktourret.poec.exam.entity.EntityInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class City implements EntityInterface {

    private Long id;

    private String name;

    private String code;

    private int population;

    private String siren;

    private Department department;

    private final List<PostalCode> postalCodeList = new ArrayList<>();

}
