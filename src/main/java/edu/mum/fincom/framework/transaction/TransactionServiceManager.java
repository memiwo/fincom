package edu.mum.fincom.framework.transaction;

/**
 * @author Issa Fikadu
 */
public class TransactionServiceManager implements TransactionService {
    @Override
    public void process(ITransaction transaction) {
        transaction.execute();
    }
}
