package edu.mum.fincom.framework.service;

import edu.mum.fincom.framework.party.ICustomer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Issa Fikadu
 */
class CustomerServiceFacade implements CustomerService {
    List<ICustomer> customers;
    public CustomerServiceFacade(){
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
