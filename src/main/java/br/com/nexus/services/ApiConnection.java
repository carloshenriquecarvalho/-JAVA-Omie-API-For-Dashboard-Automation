package br.com.nexus.services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConnection {
    private final String API_URL = "https://app.omie.com.br/api/v1/produtos/pedido/";
    private final String APP_SECRET = "a0486e8e0d2fd9b8062f13182e68754d";
    private final String APP_KEY = "2831120835543";
    private final String JSON_BODY = """ 
            {
            "call":"ListarPedidos",
            "param":[
            {
                "pagina":1,
                    "registros_por_pagina":2,
                    "apenas_importado_api":"N"
                }],
                    "app_key":"%s",
                    "app_secret":"%s"
            }""".formatted(APP_KEY, APP_SECRET);

    HttpClient httpClient = HttpClient.newHttpClient();

    HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create(API_URL)).
            header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(JSON_BODY))
            .build();
    public String sendRequest(){
        try{
            HttpResponse<String> responseJson = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            System.out.println("Success code: " + responseJson.statusCode());
            return responseJson.body();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


}
