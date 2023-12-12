package fr.ktourret.poec.my_mvc.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Country {

    private Long id;

    private String name;

    private String nationality;

    private String code;

    private String urlFlag;

    private String slug;

}
