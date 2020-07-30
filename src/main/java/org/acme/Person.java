package org.acme;

import java.time.LocalDate;

public class Person {
    private String name;
    private LocalDate terminationDate;

    public Person(String name, LocalDate terminationDate) {
        this.name = name;
        this.terminationDate = terminationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(LocalDate terminationDate) {
        this.terminationDate = terminationDate;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", terminationDate=" + terminationDate + "]";
    }
}