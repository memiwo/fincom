package edu.mum.fincom.framework.party;

import edu.mum.fincom.framework.IAccount;

import java.util.List;

/**
 * @author Issa Fikadu
 */
public interface ICustomer {
    void addAccount(IAccount account);
    void removeAccount(IAccount account);
    void sendEmail(String message);
    Address getAddress();
    List<IAccount> getAccounts();
}
