package edu.mum.fincom.framework.party;

import java.util.Date;

/**
 * @author Issa Fikadu
 */
public class Person extends Customer implements IPerson {

    private Date birthDate;

    public Person(String name,Address address, Date birthDate) {
        super(name, address);
        this.birthDate = birthDate;
    }

    @Override
    public Date getBirthDate() {
        return null;
    }


}
