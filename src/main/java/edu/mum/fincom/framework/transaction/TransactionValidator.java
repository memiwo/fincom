package edu.mum.fincom.framework.transaction;

import edu.mum.fincom.framework.IAccount;

/**
 * @author Issa Fikadu
 */
public interface TransactionValidator {
    boolean validate(IAccount account, double amount);
}
