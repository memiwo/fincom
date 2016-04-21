package edu.mum.fincom.framework.factory;


/**
 * @author Issa Fikadu
 */
public class DefaultFinComFactory implements FinComFactory {

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
