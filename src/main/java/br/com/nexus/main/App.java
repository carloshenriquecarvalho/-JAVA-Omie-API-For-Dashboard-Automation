package br.com.nexus.main;

import br.com.nexus.services.ApiConnection;

public class App {
    public static void main(String[] args) {
        ApiConnection apiConnection = new ApiConnection();
        var data = apiConnection.sendRequest();

        System.out.println(data);
    }
}
