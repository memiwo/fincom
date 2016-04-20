package edu.mum.fincom.banking.factory;

import edu.mum.fincom.banking.account.AccountType;
import edu.mum.fincom.framework.IAccount;
import edu.mum.fincom.framework.factory.AccountFactory;
import org.springframework.stereotype.Component;

/**
 * @author Issa Fikadu
 */

public class BankAccountFactory implements AccountFactory{

    IAccount account;

    public BankAccountFactory(AccountType type){

    }

    @Override
    public IAccount createAccount() {
        return this.account;
    }

}
