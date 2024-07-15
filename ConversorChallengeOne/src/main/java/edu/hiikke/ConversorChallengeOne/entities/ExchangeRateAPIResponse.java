package edu.hiikke.ConversorChallengeOne.entities;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public record ExchangeRateAPIResponse(@SerializedName("conversion_rates") Map<String, Double> valoresCambio) {
}
