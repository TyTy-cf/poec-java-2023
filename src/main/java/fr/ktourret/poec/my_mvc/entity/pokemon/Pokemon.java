package fr.ktourret.poec.my_mvc.entity.pokemon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pokemon {

    private Long id;

    private String name;

    private String frontDefault;

    private List<Type> types = new ArrayList<>();

    public void addType(Type type) {
        types.add(type);
    }

}