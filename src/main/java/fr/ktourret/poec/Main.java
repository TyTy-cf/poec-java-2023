package fr.ktourret.poec;

import fr.ktourret.poec.my_mvc.service.Dump;
import fr.ktourret.poec.my_mvc.service.HttpClientService;
import fr.ktourret.poec.my_mvc.service.PokeApiService;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        PokeApiService pas = new PokeApiService();
        for (int i = 0; i < 11000; i++) {
            pas.getPokemon(i);
        }
    }

    private static void testApiPost() {
        HttpClientService hcs = new HttpClientService();

        // On peut créer un JSON valide depuis un objet Map, via le JSONObject
        Map<String, Object> json = new HashMap<>();
        json.put("name", "Donovan");
        json.put("email", "donovan@kevin.fr");
        json.put("nickname", "Dono");
        json.put("password", "Kevin1234");
        JSONObject o = new JSONObject(json);

        Dump.dump(hcs.post("https://steam-ish.test-02.drosalys.net/api/account", o.toString()));

    }

}