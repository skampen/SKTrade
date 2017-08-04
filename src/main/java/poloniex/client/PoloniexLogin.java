package poloniex.client;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class PoloniexLogin {
    static final String JSONFILE = "./src/main/resources/login.json";

    public static HashMap<String, String> getCredentials() {
        String jsonString = new String();
        try {
            jsonString = new String(Files.readAllBytes(Paths.get(JSONFILE)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = new JSONArray(jsonString).getJSONObject(0);
        HashMap<String, String> credentials = new HashMap<>();
        credentials.put("apiKey", jsonObject.get("apiKey").toString());
        credentials.put("apiSecret", jsonObject.get("apiSecret").toString());
        return credentials;
    }
}

