package edu.mum.fincom.framework.service;

import edu.mum.fincom.framework.transaction.TransactionService;
import edu.mum.fincom.framework.transaction.TransactionServiceManager;

/**
 * @author Issa Fikadu
 */
public class SimpleServiceFactory {
    private static CustomerService customerService = new CustomerServiceManager();
    private static TransactionService transactionService = new TransactionServiceManager();
    private static AccountService accountService = new AccountServiceManager();

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
