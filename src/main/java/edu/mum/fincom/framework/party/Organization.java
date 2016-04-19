package edu.mum.fincom.framework.party;

/**
 * @author Issa Fikadu
 */
public class Organization extends Customer implements IOrganization {
    private int noOfEmployees;

    public Organization(String name, Address address, int noOfEmployees) {
        super(name, address);
        this.noOfEmployees = noOfEmployees;
    }

    public int getNoOfEmployees() {
        return noOfEmployees;
    }
}
