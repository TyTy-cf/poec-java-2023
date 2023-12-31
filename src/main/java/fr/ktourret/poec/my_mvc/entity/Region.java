package fr.ktourret.poec.my_mvc.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Region implements EntityInterface {

    private Long id;
    private String name;
    private String code;

}