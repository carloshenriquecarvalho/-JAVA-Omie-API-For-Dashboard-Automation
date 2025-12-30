package br.com.nexus.main;

import br.com.nexus.services.ApiConnection;
import br.com.nexus.services.ApiGetSells;

public class App {
    public static void main(String[] args) {
        ApiGetSells apiGetSells = new ApiGetSells();

        System.out.println(apiGetSells.getSells());
    }
}
