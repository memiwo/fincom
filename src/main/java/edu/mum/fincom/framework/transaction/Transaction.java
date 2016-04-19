package edu.mum.fincom.framework.transaction;

import edu.mum.fincom.framework.IAccount;
import edu.mum.fincom.framework.party.Person;

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
     */
    @Override
    final public void execute() {
        if (getValidator().validate(account, amount)){
            process(account, amount);

           /* if (account instanceof Person && amount < 500){

            }*/
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
