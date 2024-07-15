package edu.hiikke.ConversorChallengeOne.services.ExchangeRateAPIConnection;

import com.google.gson.Gson;
import edu.hiikke.ConversorChallengeOne.entities.ExchangeRateAPIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ExchangeRateAPIConsumo {

  ExchangeRateAPIConnection exchangeRateAPIConnection;

  @Autowired
  public ExchangeRateAPIConsumo(ExchangeRateAPIConnection exchangeRateAPIConnection) {
    this.exchangeRateAPIConnection = exchangeRateAPIConnection;
  }

  public ExchangeRateAPIResponse consultarCambio(String moedaBase) throws IOException, InterruptedException {
    // Faz a consulta, pega os valores de conversão e retorna uma entidade mapeada com esses dados pela serialize do Gson.
    String request = exchangeRateAPIConnection.consultaCambioAPI(moedaBase);
    Gson gson = new Gson();

    return gson.fromJson(request, ExchangeRateAPIResponse.class);
  }

  public Double realizarConversao(String moedaBase, String moedaFinal, int valorMoedaBase) throws IOException, InterruptedException {
    // Pega o retorno da consulta do cambio, realiza a multiplicação e retorna o resultado.
    ExchangeRateAPIResponse exchangeRateAPIResponse = consultarCambio(moedaBase);
    return valorMoedaBase * exchangeRateAPIResponse.valoresCambio().get(moedaFinal);
  }
}
