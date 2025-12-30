package br.com.nexus.services;

import br.com.nexus.loader.ConfigLoader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConnection {
    private final String APP_SECRET = ConfigLoader.get("omie.app.secret");
    private final String APP_KEY = ConfigLoader.get("omie.app.key");

    private final String REQUEST_TEMPLATE = """
            {
                "call": "%s",
                "param": %s,
                "app_key": "%s",
                "app_secret": "%s"
            }
            """;

    public String sendRequest(String urlLastPart,String callName, String paramJsonArray){
        try {
            String API_URL = ConfigLoader.get("omie.api.url") + urlLastPart;
            String fullBody = REQUEST_TEMPLATE.formatted(
                    callName,
                    paramJsonArray,
                    APP_KEY,
                    APP_SECRET
            );

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(fullBody))
                    .build();

            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                System.out.println("Error: " + response.statusCode());
                System.out.println(response.body());
            }

            return response.body();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}