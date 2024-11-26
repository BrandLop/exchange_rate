import com.google.gson.Gson;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateService {
    public ExchangeRate exchangeRate(String base_currency, String target_currency, Double amount_to_convert) {
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("EXCHANGE_RATE_API_KEY");

        if (apiKey == null) {
            throw new RuntimeException("API Key no encontrada");
        }

        String amout_parced = String.valueOf(amount_to_convert);
        URI link = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + base_currency + "/" + target_currency + "/" + amout_parced);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(link)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ExchangeRate.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error en conversion de divisa");
        }
    }
}
