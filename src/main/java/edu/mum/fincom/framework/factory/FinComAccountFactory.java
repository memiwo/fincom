package edu.mum.fincom.framework.factory;

import edu.mum.fincom.framework.Account;
import edu.mum.fincom.framework.IAccount;
import edu.mum.fincom.framework.party.ICustomer;

/**
 * @author Issa Fikadu
 */
public class FinComAccountFactory implements AccountFactory {

    private IAccount account;
    public FinComAccountFactory(ICustomer customer){
        account = new Account(customer);
    }
    @Override
    public IAccount createAccount() {
        return account;
    }
}
