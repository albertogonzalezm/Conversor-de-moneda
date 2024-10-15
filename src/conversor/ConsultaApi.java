package conversor;

import com.google.gson.Gson;
import modelos.Moneda;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {

    public Moneda buscaMoneda() {
        URI uri = URI.create("https://v6.exchangerate-api.com/v6/6b9e02eb7eb88c6e5e327b71/latest/USD");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 404) throw new Exception();
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontre esa moneda");
        }
    }
}
