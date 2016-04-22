package edu.mum.fincom.framework.factory;

import edu.mum.fincom.banking.TransactionType;
import edu.mum.fincom.framework.IAccount;
import edu.mum.fincom.framework.transaction.DepositTransaction;
import edu.mum.fincom.framework.transaction.ITransaction;
import edu.mum.fincom.framework.transaction.TransactionValidator;
import edu.mum.fincom.framework.transaction.WithdrawTransaction;

/**
 * @author Issa Fikadu
 */
public class FinComTransactionFactory implements TransactionFactory {

    private ITransaction transaction;

    public FinComTransactionFactory(TransactionType type, IAccount account, double amount, TransactionValidator validator){
        switch (type){
            case DEPOSIT:
                transaction = new DepositTransaction(account, amount,validator);
                break;
            case WITHDRAWAL:
                transaction = new WithdrawTransaction(account, amount, validator);
                break;
        }

    }


    @Override
    public ITransaction createTransaction() {
        return transaction;
    }
}
