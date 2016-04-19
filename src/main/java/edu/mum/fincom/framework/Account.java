package edu.mum.fincom.framework;

import edu.mum.fincom.framework.party.ICustomer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Issa Fikadu
 */
public abstract class Account implements IAccount {
    private ICustomer customer;
    private List<IEntry> entries;
    private double balance;

    public Account(ICustomer customer) {
        this.customer = customer;
        this.entries = new ArrayList<>();
    }

    @Override
    public void addEntry(IEntry entry) {
        entries.add(entry);
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public List<IEntry> getEntries() {
        return entries;
    }

    @Override
    public ICustomer getCustomer() {
        return customer;
    }
}
