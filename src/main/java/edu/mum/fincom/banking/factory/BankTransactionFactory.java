package edu.mum.fincom.banking.factory;

import edu.mum.fincom.framework.IAccount;
import edu.mum.fincom.framework.factory.TransactionFactory;
import edu.mum.fincom.framework.transaction.DepositTransaction;
import edu.mum.fincom.framework.transaction.ITransaction;
import edu.mum.fincom.framework.transaction.WithdrawTransaction;

/**
 * @author Issa Fikadu
 */
public class BankTransactionFactory implements TransactionFactory {

    private ITransaction transaction;

    public BankTransactionFactory(TransactionType type, IAccount account, double amount){
        switch (type){
            case DEPOSIT:
                transaction = new DepositTransaction(account, amount);
                break;
            case WITHDRAWAL:
                transaction = new WithdrawTransaction(account, amount);
                break;
        }

    }


    @Override
    public ITransaction createTransaction() {
        return transaction;
    }
}
