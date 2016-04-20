package edu.mum.fincom.framework.factory;

import edu.mum.fincom.framework.transaction.ITransaction;

/**
 * @author Issa Fikadu
 */
public interface TransactionFactory {
    ITransaction createTransaction();
}
