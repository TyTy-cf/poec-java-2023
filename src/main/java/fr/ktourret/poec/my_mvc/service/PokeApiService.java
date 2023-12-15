package fr.ktourret.poec.my_mvc.service;

import fr.ktourret.poec.my_mvc.entity.pokemon.Pokemon;
import fr.ktourret.poec.my_mvc.entity.pokemon.Type;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class PokeApiService {

    private HttpClientService httpClientService = new HttpClientService();

    public Pokemon getPokemon(String name) {
        String url = "https://pokeapi.co/api/v2/pokemon/" + name;
        String json = httpClientService.get(url);
        if (json.isEmpty()) {
            return null;
        }
        JSONTokener tokener = new JSONTokener(json);
        JSONObject object = new JSONObject(tokener);

        // Obligatoire pour aller dans other
        JSONObject sprites = object.getJSONObject("sprites");
        JSONObject other = sprites.getJSONObject("other");
        JSONObject home = other.getJSONObject("home");

        Pokemon pokemon = new Pokemon();
        pokemon.setId(object.getLong("id"));
        pokemon.setName(object.getString("name"));
        pokemon.setFrontDefault(home.getString("front_default"));

        // Récupération des types
        JSONArray types = object.getJSONArray("types");
        for (int i = 0; i < types.length(); i++) {
            JSONObject sType = types.getJSONObject(i);
            JSONObject jType = sType.getJSONObject("type");
            pokemon.addType(new Type(jType.getString("name")));
        }

        return pokemon;
    }

}
