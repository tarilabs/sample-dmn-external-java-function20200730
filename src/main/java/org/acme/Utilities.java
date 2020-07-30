package org.acme;

import java.time.LocalDate;

public class Utilities {
    public static boolean checkTerminationDate(Person person) {
        LocalDate date = person.getTerminationDate();
        LocalDate current = LocalDate.now();
        if (date.isBefore(current)) {
            return true;
        } else {
            return false;
        }
    }
}