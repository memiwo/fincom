package edu.mum.fincom.framework.party;

import edu.mum.fincom.framework.IAccount;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Issa Fikadu
 */
public abstract class Customer implements ICustomer {
    private String name;
    private Address address;
    List<IAccount> accounts;

    public Customer(String name, Address address){
        this.name = name;
        this.address = address;
        accounts = new ArrayList<>();
    }

    public void addAccount(IAccount account) {
        accounts.add(account);
    }

    public void removeAccount(final IAccount account) {
        accounts.removeIf(acc -> acc.equals(account));

    }

    public void sendEmail(String message) {

        System.out.println("Email: "+message);
    }

    @Override
    public Address getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    @Override
    public List<IAccount> getAccounts() {
        return accounts;
    }
}
