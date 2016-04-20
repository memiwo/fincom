package edu.mum.fincom.framework.transaction;

/**
 * @author Issa Fikadu
 */
public interface TransactionService {
    void process(ITransaction transaction);
}
