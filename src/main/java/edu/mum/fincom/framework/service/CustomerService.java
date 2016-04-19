package edu.mum.fincom.framework.service;

import edu.mum.fincom.framework.party.ICustomer;

/**
 * @author Issa Fikadu
 */
interface CustomerService {
    void createCustomer(ICustomer customer);
    void removeCustomer(ICustomer customer);
}
