package com.sda.javagdy4.apirekrutacyjne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NBPApiParameters {
    private LocalDate startDate;
    private LocalDate endDate;
    private NBPCurrency currency;
}
