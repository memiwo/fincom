package edu.mum.fincom.framework;

import java.time.LocalDate;

/**
 * @author Issa Fikadu
 */
public class Entry implements IEntry {
    private double amount;
    private LocalDate date;
    private String description;

    public Entry(double amount, LocalDate date, String description) {
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
