package edu.mum.fincom.framework.transaction;

import edu.mum.fincom.framework.IAccount;

/**
 * @author Issa Fikadu
 */
public class WithdrawTransactionValidator implements TransactionValidator {
    @Override
    public boolean validate(IAccount account, double amount) {
        if (account.getBalance() < amount){
            throw new InsufficientBalanceException("Insufficient Balance");
        }
        return true;
    }

    @Override
    public void postTransaction(IAccount account, double amount) {

    }
}
