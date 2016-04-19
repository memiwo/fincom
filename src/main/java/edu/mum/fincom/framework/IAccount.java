package edu.mum.fincom.framework;

import java.util.List;

/**
 * @author Issa Fikadu
 */
public interface IAccount {
    void addEntry(IEntry entry);
    double getBalance();
    List<IEntry> getEntries();
}
