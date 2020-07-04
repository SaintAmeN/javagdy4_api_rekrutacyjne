package com.sda.javagdy4.apirekrutacyjne;

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
}
