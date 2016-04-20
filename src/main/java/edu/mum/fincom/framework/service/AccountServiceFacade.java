package edu.mum.fincom.framework.service;

import edu.mum.fincom.framework.Entry;
import edu.mum.fincom.framework.IAccount;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Issa Fikadu
 */
class AccountServiceFacade implements AccountService {

    List<IAccount> accounts;

    public AccountServiceFacade(){
        accounts = new ArrayList<>();
    }

    @Override
    public IAccount getAccountByName(String name) {
        return accounts.stream().filter(ac -> ac.getCustomer().getName().equals(name)).findAny().get();
    }

    @Override
    public void createAccount(IAccount account) {

        accounts.add(account);
    }

    @Override
    public void addInterest() {

        accounts.stream().forEach(ac -> ac.addEntry(new Entry(ac.getBalance()*ac.getInterestRate(), LocalDate.now(),"Interest")));
    }
}
