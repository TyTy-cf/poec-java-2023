package fr.ktourret.poec.my_mvc.entity.pokemon;

import fr.ktourret.poec.my_mvc.entity.EntityInterface;
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
public class Pokemon implements EntityInterface {

    private Long id;

    private Long pokedexId;

    private String name;

    private String frontDefault;

    private String frontShiny;

    private Integer height;

    private Integer weight;

    private Integer baseExperience;

    private List<Type> types = new ArrayList<>();

    private List<Stat> stats = new ArrayList<>();

    private List<Ability> abilities = new ArrayList<>();

    public void addType(Type type) {
        types.add(type);
    }

    public void addAbility(Ability ability) {
        abilities.add(ability);
    }

    public void addStat(Stat stat) {
        stats.add(stat);
    }

}