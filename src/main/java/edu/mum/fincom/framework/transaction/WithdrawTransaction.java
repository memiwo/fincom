package edu.mum.fincom.framework.transaction;

import edu.mum.fincom.framework.Entry;
import edu.mum.fincom.framework.IAccount;

import java.time.LocalDate;

/**
 * @author Issa Fikadu
 */
public class WithdrawTransaction extends Transaction {
    private TransactionValidator transactionValidator;

    public WithdrawTransaction(IAccount account, double amount) {
        super(account, amount);
        this.transactionValidator = SimpleTransactionValidatorFactory.getWithdrawTransactionValidator();
    }

    public WithdrawTransaction(IAccount account, double amount, TransactionValidator transactionValidator) {
        this(account, amount);
        this.transactionValidator = transactionValidator;
    }

    @Override
    public void process(IAccount account, double amount) {
        account.addEntry(new Entry(amount, LocalDate.now(), "withdraw"));
    }

    @Override
    public TransactionValidator getValidator() {
        return transactionValidator;
    }
}
