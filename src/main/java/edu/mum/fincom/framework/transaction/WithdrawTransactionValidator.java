package edu.mum.fincom.framework.transaction;

import edu.mum.fincom.framework.IAccount;
import edu.mum.fincom.framework.party.IOrganization;
import edu.mum.fincom.framework.party.IPerson;

/**
 * @author Issa Fikadu
 */
public class WithdrawTransactionValidator implements TransactionValidator {
    private double thresholdAmount;

    public WithdrawTransactionValidator(double thresholdAmount){
        this.thresholdAmount = thresholdAmount;
    }
    @Override
    public boolean validate(IAccount account, double amount) {
        if (amount <= 0) return false;
        if (account.getBalance() < amount){
            throw new InsufficientBalanceException("Insufficient Balance");
        }
        return true;
    }

    @Override
    public void postTransaction(IAccount account, double amount) {
        if (account instanceof IOrganization){
            account.getCustomer().sendEmail("A withdraw of "+amount+" has been made on your account");
        }else if((account instanceof IPerson) && amount > thresholdAmount ){
            account.getCustomer().sendEmail("A withdraw of "+amount+" has been made on your account");
        }
    }
}
