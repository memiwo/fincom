package edu.mum.fincom.framework.transaction;

import edu.mum.fincom.framework.IAccount;

/**
 * @author Issa Fikadu
 */
public class DepositTransactionValidator implements TransactionValidator {
    @Override
    public boolean validate(IAccount account, double amount) {
        return true;
    }
}
