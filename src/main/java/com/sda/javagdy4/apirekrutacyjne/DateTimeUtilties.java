package com.sda.javagdy4.apirekrutacyjne;

import com.sda.javagdy4.apirekrutacyjne.exception.DateTimeParsingException;
import lombok.extern.log4j.Log4j;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Log4j
public class DateTimeUtilties {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * Method processes input string given in format <code>yyyy-MM-dd</code>.
     *
     * @param input - input in format <code>yyyy-MM-dd</code>
     * @return parsed local date instance
     * @throws DateTimeParsingException - exception that might happen when there is parsing exception or date is after yesterday.
     */
    public static LocalDate loadEndDate(String input) throws DateTimeParsingException {
        LocalDate loadedDate;
        try {
            loadedDate = LocalDate.parse(input, FORMATTER);

            // sprawdzamy czy załadowana data jest po wczoraj
            if (loadedDate.isAfter(LocalDate.now().minusDays(1))) {
                throw new DateTimeParseException("End date should be no later than yesterday.", input, 1);
            }
        } catch (DateTimeParseException dtpe) {
            log.error("Błąd parsowania daty.");
            throw new DateTimeParsingException(dtpe.getMessage());
        }
        return loadedDate;
    }

    public static LocalDate loadStartDate(String input, LocalDate endDate) throws DateTimeParsingException {
        LocalDate loadedDate;
        try {
            loadedDate = LocalDate.parse(input, FORMATTER);

            // sprawdzamy czy załadowana data jest po wczoraj
            if (loadedDate.isAfter(endDate.minusDays(1))) {
                throw new DateTimeParseException("Start date should be no later than end date.", input, 1);
            }
        } catch (DateTimeParseException dtpe) {
            log.error("Błąd parsowania daty.");
            throw new DateTimeParsingException(dtpe.getMessage());
        }
        return loadedDate;
    }
}
