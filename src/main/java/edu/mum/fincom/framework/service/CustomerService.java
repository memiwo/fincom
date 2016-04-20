package edu.mum.fincom.framework.service;

import edu.mum.fincom.framework.party.ICustomer;

/**
 * @author Issa Fikadu
 */
public interface CustomerService {
    void createCustomer(ICustomer customer);
    void removeCustomer(ICustomer customer);
}
