package edu.mum.fincom.creditcard.account;

import edu.mum.fincom.framework.Account;
import edu.mum.fincom.framework.party.ICustomer;

/**
 * @author Issa Fikadu
 */
public class BronzeAccount extends Account {

    public BronzeAccount(ICustomer customer) {
        super(customer);
    }

    public double MonthlyInterest() {
        return 10.0;
    }

    public double MInimumPayement() {
        return 14.0;
    }

    @Override
    public String getDescription() {
        return "Bronze";
    }
}
