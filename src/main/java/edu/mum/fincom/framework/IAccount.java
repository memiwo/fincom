package edu.mum.fincom.framework;

import edu.mum.fincom.framework.party.ICustomer;

import java.util.List;

/**
 * @author Issa Fikadu
 */
public interface IAccount {
    void addEntry(IEntry entry);
    double getBalance();
    List<IEntry> getEntries();
    double getInterestRate();
    ICustomer getCustomer();
}
