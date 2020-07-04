package com.sda.javagdy4.apirekrutacyjne;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.javagdy4.apirekrutacyjne.exception.NoResultException;
import com.sda.javagdy4.apirekrutacyjne.model.ExchangeRates;
import com.sda.javagdy4.apirekrutacyjne.model.NBPApiParameters;
import com.sda.javagdy4.apirekrutacyjne.model.Rate;
import lombok.extern.log4j.Log4j;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Log4j
public class NBPApi {
    private final static String API_BID_ASK_ENDPOINT = "http://api.nbp.pl/api/exchangerates/rates/C/{currency}/{startDate}/{endDate}/?format=json";
    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Rate> requestBidAskRates(NBPApiParameters parameters) {
        String requestUrl = prepareRequestURL(parameters);
        log.info("Request URL: " + requestUrl);

        HttpRequest request = HttpRequest.newBuilder()      // stwórz zapytanie
                .GET()                                      // typu get (pobieramy informacje, nie dodajemy, nie usuwamy, nie edytujemy)
                .uri(URI.create(requestUrl))                // na adres
                .build();                                   // sfinalizuj stworzenie obiektu (wzorzec projektowy builder)


        try {
            // wyśli zapytanie
            // spodziewamy się odpowiedzi w postaci String (bodyhandlers)
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String responseBody = response.body();

                ExchangeRates exchangeRates = objectMapper.readValue(responseBody, ExchangeRates.class);
                return exchangeRates.getRates();

            } else {
                System.err.println("Error: " + response.statusCode());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new NoResultException("There was no result from API call.");
    }

    private String prepareRequestURL(NBPApiParameters parameters) {
        return API_BID_ASK_ENDPOINT
                .replaceAll("\\{currency\\}", parameters.getCurrency().getShortName())
                .replaceAll("\\{startDate\\}", parameters.getStartDate().toString())
                .replaceAll("\\{endDate\\}", parameters.getEndDate().toString());
    }

}
