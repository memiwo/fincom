package edu.mum.fincom.creditcard.Customer;

import edu.mum.fincom.framework.party.Address;
import edu.mum.fincom.framework.party.Customer;

import java.util.Date;

/**
 * Created by Zeelo on 4/21/2016.
 */
public class CreditCustomer extends Customer {
    String CC_number;
    String expiryDate;

    public CreditCustomer(String name, Address address, int date, String CC_number, String expiryDate) {
        super(name, address);
        this.CC_number = CC_number;
        this.expiryDate = expiryDate;
    }

    public String getCC_number() {
        return CC_number;
    }

    public String getExpiryDate() {
        return expiryDate;
    }
}
