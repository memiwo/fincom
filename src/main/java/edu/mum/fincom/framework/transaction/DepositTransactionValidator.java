package edu.mum.fincom.framework.transaction;

import edu.mum.fincom.framework.IAccount;
import edu.mum.fincom.framework.party.IOrganization;
import edu.mum.fincom.framework.party.IPerson;

/**
 * @author Issa Fikadu
 */
public class DepositTransactionValidator implements TransactionValidator {
    private double thresholdAmount;

    public DepositTransactionValidator(double thresholdAmount){
        this.thresholdAmount = thresholdAmount;
    }
    @Override
    public boolean validate(IAccount account, double amount) {

        return true;
    }

    @Override
    public void postTransaction(IAccount account, double amount) {
        if (account instanceof IOrganization){
            account.getCustomer().sendEmail("A deposit of "+amount+" is made on your account");
        }else if((account instanceof IPerson) && amount > thresholdAmount ){
            account.getCustomer().sendEmail("A deposit of "+amount+" is made on your account");
        }
    }
}
