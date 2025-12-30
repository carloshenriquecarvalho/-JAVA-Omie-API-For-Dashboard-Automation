package br.com.nexus.services;

public class ApiGetSells {

    // Only the parameter array. No trailing comma needed!
    private final String PARAMS = """
        [
            {
                "pagina": 1,
                "registros_por_pagina": 2,
                "apenas_importado_api": "N"
            }
        ]
        """;

    public String getSells() {
        ApiConnection apiConnection = new ApiConnection();
        String urlLastPart = "produtos/pedido/";
        // Usage is much clearer now
        return apiConnection.sendRequest(urlLastPart, "ListarPedidos", PARAMS);
    }
}