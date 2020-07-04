package com.sda.javagdy4.apirekrutacyjne;

import lombok.extern.log4j.Log4j;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Log4j
public class Main {


    public static void main(String[] args) {
        NBPApi api = new NBPApi();
        Scanner scanner = new Scanner(System.in);
        NBPApiParameters parameters = new NBPApiParameters();

        loadAndSetCurrency(scanner, parameters);
        loadAndSetEndDate(scanner, parameters);
        loadAndSetStartDate(scanner, parameters);

        List<Rate> rates = api.requestBidAskRates(parameters);
        rates.forEach(log::info);
    }

    private static void loadAndSetEndDate(Scanner scanner, NBPApiParameters parameters) {
        do {
            log.info("Please enter end date [yyyy-MM-dd]:");
            try {
                parameters.setEndDate(scanner.nextLine());
            } catch (DateTimeParsingException e) {
                log.error("Wrong date: " + e.getMessage());
            }
        } while (parameters.getEndDate() == null);
    }

    private static void loadAndSetStartDate(Scanner scanner, NBPApiParameters parameters) {
        do {
            log.info("Please enter start date [yyyy-MM-dd]:");
            try {
                parameters.setStartDate(scanner.nextLine());
            } catch (DateTimeParsingException e) {
                log.error("Wrong date: " + e.getMessage());
            }
        } while (parameters.getStartDate() == null);
    }

    private static void loadAndSetCurrency(Scanner scanner, NBPApiParameters parameters) {
        do {
            log.info("Please enter currency [dolar,euro,rubel]:");
            Optional<NBPCurrency> optionalCurrency = NBPCurrency.parse(scanner.nextLine());
            if (optionalCurrency.isPresent()) {
                parameters.setCurrency(optionalCurrency.get());
            } else {
                log.error("Error: unrecognized currency.");
            }
        } while (parameters.getCurrency() == null); // wykonuj pętle, dopóki currency == null
    }
}
