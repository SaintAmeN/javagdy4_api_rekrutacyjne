package com.sda.javagdy4.apirekrutacyjne.model;

import com.sda.javagdy4.apirekrutacyjne.exception.DateTimeParsingException;
import com.sda.javagdy4.apirekrutacyjne.DateTimeUtilties;
import lombok.*;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class NBPApiParameters {
    private LocalDate startDate;
    private LocalDate endDate;

    @Setter
    private NBPCurrency currency;

    public void setEndDate(String userInput) throws DateTimeParsingException {
        this.endDate = DateTimeUtilties.loadEndDate(userInput);
    }

    public void setStartDate(String userInput) throws DateTimeParsingException {
        this.startDate = DateTimeUtilties.loadStartDate(userInput, endDate);
    }
}
