package edu.mum.fincom.banking.factory;

import edu.mum.fincom.framework.IAccount;
import edu.mum.fincom.framework.factory.AccountFactory;
import org.springframework.stereotype.Component;

/**
 * @author Issa Fikadu
 */
@Component
public class BankAccountFactory implements AccountFactory{

    IAccount account;

    @Override
    public IAccount createAccount() {
        return this.account;
    }

}
