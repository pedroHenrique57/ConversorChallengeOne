package edu.hiikke.ConversorChallengeOne.services.ExchangeRateAPIConnection;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class ExchangeRateAPIConnection {

  public String  consultaCambioAPI(String moeda) throws IOException, InterruptedException {
    //Cria a URL para a consulta da moeda correta
    String URL = "https://v6.exchangerate-api.com/v6/" + System.getenv("exchangeRateKey") + "/latest/" + moeda;

    // Cria um HTTPClient
    HttpClient client = HttpClient.newHttpClient();

    //Cria o URI do URL
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(URL))
        .build();

    // Faz a requisição
    HttpResponse<String> requestResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

    // Retorna o retorno da requisição
    return requestResponse.body();
  }
}
