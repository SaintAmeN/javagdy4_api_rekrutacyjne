package com.sda.javagdy4.apirekrutacyjne.model;

import java.util.Optional;

public enum NBPCurrency {
    AMERICAN_DOLAR("USD"),
    RUSSIAN_RUBEL("RUB"),
    EURO("EUR");

    private String shortName;

    NBPCurrency(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public static Optional<NBPCurrency> parse(String input) {
        if (input.toUpperCase().contains("DOLAR")) {
            return Optional.of(NBPCurrency.AMERICAN_DOLAR);
        } else if (input.toUpperCase().contains("RUBEL")) {
            return Optional.of(NBPCurrency.RUSSIAN_RUBEL);
        } else if (input.toUpperCase().contains("EURO")) {
            return Optional.of(NBPCurrency.EURO);
        }
        return Optional.empty();
    }
    //    NBPCurrency currency = NBPCurrency.EURO;
//        System.out.println(currency); // EURO
//        System.out.println(currency.getShortName()); // EUR
}
