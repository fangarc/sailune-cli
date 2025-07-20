package org.fangarc.model;

public enum ReadingStatus {
    COMPLETED("completed"),
    READING("reading"),
    ON_HOLD("hold"),
    DROPPED("dropped"),
    PLANNED_TO_READ("planned"),;

    private String abbreviation;

    ReadingStatus(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
