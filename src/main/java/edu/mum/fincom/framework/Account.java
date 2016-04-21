package edu.mum.fincom.framework;

import edu.mum.fincom.framework.party.ICustomer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Issa Fikadu
 */
public class Account implements IAccount {
    private ICustomer customer;
    private List<IEntry> entries;
    private double balance;

    public Account(ICustomer customer) {
        this.customer = customer;
        this.entries = new ArrayList<>();
    }

    @Override
    public final void addEntry(IEntry entry) {

        balance+=entry.getAmount();
        entries.add(entry);
    }

    @Override
    public final double getBalance() {

        return balance;
    }

    @Override
    public double getInterestRate() {
        return 0;
    }

    @Override
    public List<IEntry> getEntries() {
        return entries;
    }

    @Override
    public ICustomer getCustomer() {
        return customer;
    }

    @Override
    public String getDescription() {
        return "Def";
    }
}
