package edu.mum.fincom.framework.transaction;

import edu.mum.fincom.framework.Entry;
import edu.mum.fincom.framework.IAccount;

import java.time.LocalDate;

/**
 * @author Issa Fikadu
 */
public class DepositTransaction extends Transaction {
    private TransactionValidator transactionValidator;

    public DepositTransaction(IAccount account, double amount) {
        super(account, amount);
        this.transactionValidator = SimpleTransactionValidatorFactory.getDepositTransactionValidator();
    }

    public DepositTransaction(IAccount account, double amount, TransactionValidator transactionValidator) {
        this(account, amount);
        this.transactionValidator = transactionValidator;
    }

    @Override
    public void process(IAccount account, double amount) {
        account.addEntry(new Entry(amount, LocalDate.now(), "deposit"));


    }

    @Override
    public TransactionValidator getValidator() {
        return null;
    }
}
