package edu.mum.fincom.banking.factory;

import edu.mum.fincom.framework.factory.AccountFactory;
import edu.mum.fincom.framework.factory.CustomerFactory;
import edu.mum.fincom.framework.factory.FinComFactory;
import edu.mum.fincom.framework.factory.TransactionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author Issa Fikadu
 */
@Component
public class BankFactory implements FinComFactory {

    @Autowired
    @Qualifier(value = "bankAccountFactory")
    private AccountFactory accountFactory;
    private CustomerFactory customerFactory;
    private TransactionFactory transactionFactory;

    public BankFactory() {
    }

    @Override
    public AccountFactory createAccountFactory() {

        return accountFactory;
    }

    @Override
    public CustomerFactory createCustomerFactory() {
        return customerFactory;
    }

    @Override
    public TransactionFactory createTransactionFactory() {
        return transactionFactory;
    }


}
