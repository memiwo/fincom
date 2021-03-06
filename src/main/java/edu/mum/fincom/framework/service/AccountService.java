package edu.mum.fincom.framework.service;

import edu.mum.fincom.framework.IAccount;

import java.util.List;

/**
 * @author Issa Fikadu
 */
public interface AccountService {
    IAccount getAccountByName(String name);
    void createAccount(IAccount account);
    void addInterest();
    List<IAccount> getAccounts();

}
