package edu.mum.fincom.framework;

import java.util.Date;

/**
 * @author Issa Fikadu
 */
public class Entry implements IEntry {
    private double amount;
    private Date date;
    private String description;

    public Entry(double amount, Date date, String description) {
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
