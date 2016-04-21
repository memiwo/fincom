package edu.mum.fincom.banking.account;

import edu.mum.fincom.framework.Account;
import edu.mum.fincom.framework.party.ICustomer;
import org.springframework.stereotype.Component;

/**
 * @author Issa Fikadu
 */
public class SavingAccount extends Account {

    public SavingAccount(ICustomer customer) {
        super(customer);
    }

    @Override
    public double getInterestRate() {
        return 10;
    }

    @Override
    public String getDescription() {
        return "Saving";
    }
}
