package com.sda.javagdy4.apirekrutacyjne;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
/*
Serwis musi udostępniać endpoint SOAPowy, który jako parametr przyjmuje walutę w formie pełnej
nazwy tekstowej oraz zakres dat: początkowa i końcowa.
Dla uproszczenia zadania można przyjąć, że obecnie serwis będzie sprawdzany jedynie dla walut:
• Rubel rosyjski
• Dolar amerykański
• Euro
Format daty wejściowej serwisu jest dowolny.
 */
        Scanner scanner = new Scanner(System.in);
        NBPApiParameters parameters = new NBPApiParameters();

        loadAndSetCurrency(scanner, parameters);
//
    }

    private static void loadAndSetCurrency(Scanner scanner, NBPApiParameters parameters) {
        do {
            System.out.println("Please enter currency [dolar,euro,rubel]:");
            Optional<NBPCurrency> optionalCurrency = NBPCurrency.parse(scanner.nextLine());
            if (optionalCurrency.isPresent()) {
                parameters.setCurrency(optionalCurrency.get());
            }
        } while (parameters.getCurrency() == null); // wykonuj pętle, dopóki currency == null
    }
}
