package fr.ktourret.poec.exam.service;

import fr.ktourret.poec.exam.entity.Digimon;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DigimonService {

    private final HttpClientService httpClientService = new HttpClientService();

    public void getDigimon() {
        List<Digimon> digimonList = new ArrayList<>();
        String json = httpClientService.get("https://digimon-api.vercel.app/api/digimon");
        JSONArray jsonArray = new JSONArray(json);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            digimonList.add(
                new Digimon(
                    jsonObject.getString("name"),
                    jsonObject.getString("img"),
                    jsonObject.getString("level")
                )
            );
        }
        digimonList.forEach(Dump::dump);
    }

}
