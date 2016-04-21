package edu.mum.fincom.banking.account;

import edu.mum.fincom.framework.Account;
import edu.mum.fincom.framework.party.ICustomer;

/**
 * @author Issa Fikadu
 */
public class CheckingAccount extends Account {
     public CheckingAccount(ICustomer customer) {
        super(customer);
    }

    @Override
    public double getInterestRate() {
        return 0.6;
    }

    @Override
    public String getDescription() {
        return "Checking";
    }
}
