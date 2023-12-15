package fr.ktourret.poec.my_mvc.service;

import fr.ktourret.poec.my_mvc.entity.pokemon.Ability;
import fr.ktourret.poec.my_mvc.entity.pokemon.Pokemon;
import fr.ktourret.poec.my_mvc.entity.pokemon.Stat;
import fr.ktourret.poec.my_mvc.entity.pokemon.Type;
import fr.ktourret.poec.my_mvc.repository.pokemon.PokemonRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class PokeApiService {

    private HttpClientService httpClientService = new HttpClientService();

    private PokemonRepository pokemonRepository = new PokemonRepository();

    public Pokemon getPokemon(int id) {
        String url = "https://pokeapi.co/api/v2/pokemon/" + id;
        String json = httpClientService.get(url);
        if (json.isEmpty()) {
            return null;
        }
        try {
            JSONTokener tokener = new JSONTokener(json);
            JSONObject object = new JSONObject(tokener);

            // Obligatoire pour aller dans other
            JSONObject sprites = object.getJSONObject("sprites");
            JSONObject other = sprites.getJSONObject("other");
            JSONObject home = other.getJSONObject("home");

            Pokemon pokemon = new Pokemon();
            pokemon.setPokedexId(object.getLong("id"));
            pokemon.setName(object.getString("name"));
            pokemon.setFrontDefault(home.getString("front_default"));
            pokemon.setFrontShiny(home.getString("front_shiny"));
            pokemon.setHeight(object.getInt("height"));
            pokemon.setWeight(object.getInt("weight"));
            pokemon.setBaseExperience(object.getInt("base_experience"));

            // Récupération des types
            JSONArray types = object.getJSONArray("types");
            for (int i = 0; i < types.length(); i++) {
                pokemon.addType(new Type(getNameFromJson(types.getJSONObject(i), "type")));
            }

            JSONArray abilities = object.getJSONArray("abilities");
            for (int i = 0; i < abilities.length(); i++) {
                pokemon.addAbility(new Ability(getNameFromJson(abilities.getJSONObject(i), "ability")));
            }

            JSONArray jsonStats = object.getJSONArray("stats");
            for (int i = 0; i < jsonStats.length(); i++) {
                JSONObject stats = jsonStats.getJSONObject(i);
                pokemon.addStat(new Stat(getNameFromJson(stats, "stat"), stats.getInt("base_stat")));
            }

            return pokemonRepository.save(pokemon);
        } catch (JSONException e) {
            System.out.println(json);
        }
        return null;
    }

    private String getNameFromJson(JSONObject firstObj, String key) {
        JSONObject secondObj = firstObj.getJSONObject(key);
        return secondObj.getString("name");
    }

}
