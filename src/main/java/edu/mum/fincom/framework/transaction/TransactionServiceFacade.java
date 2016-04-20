package edu.mum.fincom.framework.transaction;

/**
 * @author Issa Fikadu
 */
public class TransactionServiceFacade implements TransactionService {
    @Override
    public void process(ITransaction transaction) {
        transaction.execute();
    }
}
