package com.sda.javagdy4.apirekrutacyjne;

import lombok.Data;

@Data
public class Rate {
    private String no;
    private String effectiveDate;
    private Double bid;
    private Double ask;
}
