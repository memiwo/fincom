package edu.mum.fincom.framework.party;

/**
 * @author Issa Fikadu
 */
public class Address {
    private String street;
    private String city;
    private String state;
    private int zip;
    private String email;

    public Address(String street, String city, String state, int zip, String email) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZip() {
        return zip;
    }

    public String getEmail() {
        return email;
    }
}
