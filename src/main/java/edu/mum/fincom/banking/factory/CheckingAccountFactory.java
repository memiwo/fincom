package edu.mum.fincom.banking.factory;

import edu.mum.fincom.banking.account.CheckingAccount;
import edu.mum.fincom.framework.IAccount;
import edu.mum.fincom.framework.factory.AccountFactory;
import edu.mum.fincom.framework.party.ICustomer;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Issa Fikadu
 */
@Component
@Scope("prototype")
public class CheckingAccountFactory implements AccountFactory {

    private ICustomer customer;

    @Override
    public IAccount createAccount() {
        return new CheckingAccount(customer);
    }

    public void setCustomer(ICustomer customer){
        this.customer = customer;
    }
}
