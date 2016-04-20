package edu.mum.fincom.framework.service;

import edu.mum.fincom.framework.transaction.TransactionService;
import edu.mum.fincom.framework.transaction.TransactionServiceFacade;

/**
 * @author Issa Fikadu
 */
public class SimpleServiceFactory {
    private static CustomerService customerService = new CustomerServiceFacade();
    private static TransactionService transactionService = new TransactionServiceFacade();
    private static AccountService accountService = new AccountServiceFacade();

    public static CustomerService getCustomerService(){
        return customerService;
    }

    public static TransactionService getTransactionService(){
        return transactionService;
    }

    public static AccountService getAccountService(){
        return accountService;
    }
}
