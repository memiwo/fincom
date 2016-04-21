package edu.mum.fincom.framework.factory;

import edu.mum.fincom.framework.Account;
import edu.mum.fincom.framework.IAccount;

/**
 * @author Issa Fikadu
 */
public class DefaultFinComFactory implements FinComFactory {
    @Override
    public AccountFactory createAccountFactory() {
        return new AccountFactory() {
            @Override
            public IAccount createAccount() {
                return new Account(null);
            }
        };
    }

    @Override
    public CustomerFactory createCustomerFactory() {
        return null;
    }

    @Override
    public TransactionFactory createTransactionFactory() {
        return null;
    }
}
