package fr.ktourret.poec.my_mvc.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Country implements EntityInterface {

    private Long id;

    private String name;

    private String nationality;

    private String code;

    private String urlFlag;

    private String slug;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(getClass().getSimpleName());
        sb.append("\n");
        sb.append("(");
        sb.append("\n");
        sb.append("\tid : ");
        sb.append(id);
        sb.append("\n");
        sb.append("\tname : ");
        sb.append(name);
        sb.append("\n");
        sb.append(")");
        sb.append("\n");
        return sb.toString();
    }
}
