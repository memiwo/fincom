package edu.mum.fincom.banking.account;

import edu.mum.fincom.framework.Account;
import edu.mum.fincom.framework.party.ICustomer;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Issa Fikadu
 */
@Component
@Scope()
public class CheckingAccount extends Account {

    public CheckingAccount(ICustomer customer) {
        super(customer);
    }


    @Override
    public double getInterestRate() {
        return 0;
    }
}
