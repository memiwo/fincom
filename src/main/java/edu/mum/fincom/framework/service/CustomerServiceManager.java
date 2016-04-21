package edu.mum.fincom.framework.service;

import edu.mum.fincom.framework.party.ICustomer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Issa Fikadu
 */
class CustomerServiceManager implements CustomerService {
    List<ICustomer> customers;
    public CustomerServiceManager(){
        customers = new ArrayList<>();
    }
    @Override
    public void createCustomer(ICustomer customer) {

        customers.add(customer);
    }

    @Override
    public void removeCustomer(ICustomer customer) {

        customers.removeIf(c -> c.getName().equals(customer.getName()));
    }
}
