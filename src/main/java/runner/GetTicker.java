package runner;

import poloniex.client.interfaces.PoloniexExchangeService;
import poloniex.data.model.poloniex.PoloniexTicker;

import java.util.HashMap;
import java.util.Timer;

import static poloniex.client.PoloniexLogin.getCredentials;

public class GetTicker {

    public static void main(String[] args) {
//        Timer timer = new Timer();
//        timer.schedule(new storeTicker(), 0, 5000);

        HashMap<String, String> credentials = getCredentials();
        PoloniexExchangeService service = new PoloniexExchangeService(credentials.get("apiKey"), credentials.get("apiSecret"));

        PoloniexTicker btcTicker = service.returnTicker("USDT_BTC");
        String x = "x";
    }


}
