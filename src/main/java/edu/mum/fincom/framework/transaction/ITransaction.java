package edu.mum.fincom.framework.transaction;

import edu.mum.fincom.framework.IAccount;

/**
 * @author Issa Fikadu
 */
public interface ITransaction {
    void execute();
    double getAmount();
    IAccount getAccount();
}
