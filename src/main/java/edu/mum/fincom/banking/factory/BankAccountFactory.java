package edu.mum.fincom.banking.factory;

import edu.mum.fincom.banking.account.AccountType;
import edu.mum.fincom.banking.account.CheckingAccount;
import edu.mum.fincom.banking.account.SavingAccount;
import edu.mum.fincom.framework.IAccount;
import edu.mum.fincom.framework.factory.AccountFactory;
import edu.mum.fincom.framework.party.ICustomer;

/**
 * @author Issa Fikadu
 */

public class BankAccountFactory implements AccountFactory{

   private IAccount account;

    public BankAccountFactory(AccountType type, ICustomer customer){
        switch (type){
            case CHECKING:
                account = new CheckingAccount(customer);
                break;
            case SAVING:
                account = new SavingAccount(customer);
                break;
        }

    }

    @Override
    public IAccount createAccount() {
        return this.account;
    }

}
