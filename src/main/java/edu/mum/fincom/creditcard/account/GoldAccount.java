package edu.mum.fincom.creditcard.account;

import edu.mum.fincom.framework.Account;
import edu.mum.fincom.framework.party.ICustomer;

/**
 * @author Issa Fikadu
 */
public class GoldAccount extends Account {

    public GoldAccount(ICustomer customer) {
        super(customer);
    }

    public double MonthlyInterest() {
        return 6;
    }

    public double MInimumPayement() {
        return 10.0;
    }

    @Override
    public String getDescription() {
        return "Gold";
    }
}
