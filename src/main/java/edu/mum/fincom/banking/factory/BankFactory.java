package edu.mum.fincom.banking.factory;

import edu.mum.fincom.framework.factory.AccountFactory;
import edu.mum.fincom.framework.factory.CustomerFactory;
import edu.mum.fincom.framework.factory.FinComFactory;
import edu.mum.fincom.framework.factory.TransactionFactory;
import org.springframework.stereotype.Component;

/**
 * @author Issa Fikadu
 */
@Component
public class BankFactory implements FinComFactory {

    private AccountFactory accountFactory;
    private CustomerFactory customerFactory;
    private TransactionFactory transactionFactory;

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

    public void setAccountFactory(AccountFactory accountFactory) {
        this.accountFactory = accountFactory;
    }

    public void setCustomerFactory(CustomerFactory customerFactory) {
        this.customerFactory = customerFactory;
    }

    public void setTransactionFactory(TransactionFactory transactionFactory) {
        this.transactionFactory = transactionFactory;
    }
}
