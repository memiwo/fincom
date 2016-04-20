package edu.mum.fincom.framework.factory;

/**
 * @author Issa Fikadu
 */
public interface FinComFactory {
    AccountFactory createAccountFactory();
    CustomerFactory createCustomerFactory();
    TransactionFactory createTransactionFactory();

}
