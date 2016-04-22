package edu.mum.fincom.creditcard.account;

import edu.mum.fincom.framework.Account;
import edu.mum.fincom.framework.party.ICustomer;

/**
 * @author Issa Fikadu
 */
public class SilverAccount extends Account {

    public SilverAccount(ICustomer customer) {
        super(customer);
    }

    public double MonthlyInterest() {
        return 8.0;
    }

    public double MInimumPayement() {
        return 12.0;
    }

    @Override
    public String getDescription() {
        return "Silver";
    }
}
