package edu.mum.fincom.framework.transaction;

import edu.mum.fincom.framework.IAccount;

/**
 * @author Issa Fikadu
 */
public abstract class Transaction implements ITransaction {
    private double amount;
    private IAccount account;

    public Transaction(IAccount account, double amount){
        this.account = account;
        this.amount = amount;
    }


    /**
     * A template method pattern that defines a steps for execution of transaction to first validate the transaction
     * and process postTransaction
     */
    @Override
    final public void execute() {
        if (getValidator().validate(account, getAmount())){
            process(account, amount);
            getValidator().postTransaction(account, amount);
        }

    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public IAccount getAccount() {
        return account;
    }

    abstract public void process(IAccount account, double amount);
    abstract public TransactionValidator getValidator();


}
