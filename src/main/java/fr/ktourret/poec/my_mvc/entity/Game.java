package fr.ktourret.poec.my_mvc.entity;

import fr.ktourret.poec.courses.entity.bank.Operation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Game {

    private Long id;

    private String name;

    private String description;

    private double price;

    private Date publishedAt;

    private String thumbnailCover;

    private String slug;

    private Publisher publisher;

    private List<Category> categories = new ArrayList<>();

    private List<Country> countries = new ArrayList<>();

    public void addCategory(Category category) {
        this.categories.add(category);
    }

    public void addCountry(Country country) {
        this.countries.add(country);
    }

}