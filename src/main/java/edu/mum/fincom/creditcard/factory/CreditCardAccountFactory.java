package edu.mum.fincom.creditcard.factory;

import edu.mum.fincom.creditcard.account.AccountType;
import edu.mum.fincom.banking.account.CheckingAccount;
import edu.mum.fincom.banking.account.SavingAccount;
import edu.mum.fincom.creditcard.account.BronzeAccount;
import edu.mum.fincom.creditcard.account.GoldAccount;
import edu.mum.fincom.creditcard.account.SilverAccount;
import edu.mum.fincom.framework.IAccount;
import edu.mum.fincom.framework.factory.AccountFactory;
import edu.mum.fincom.framework.party.ICustomer;

/**
 * @author Issa Fikadu
 */

public class CreditCardAccountFactory implements AccountFactory{

   private IAccount account;

    public CreditCardAccountFactory(AccountType type, ICustomer customer){
        switch (type){
            case GOLD:
                account = new GoldAccount(customer);
                break;
            case BRONZE:
                account = new BronzeAccount(customer);
                break;
            case SILVER:
                account = new SilverAccount(customer);
                break;
        }

    }

    @Override
    public IAccount createAccount() {
        return this.account;
    }

}
