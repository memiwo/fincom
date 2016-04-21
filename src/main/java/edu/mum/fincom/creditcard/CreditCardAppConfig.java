package edu.mum.fincom.creditcard;

import edu.mum.fincom.banking.account.CheckingAccount;
import edu.mum.fincom.framework.IAccount;
import edu.mum.fincom.framework.party.Address;
import edu.mum.fincom.framework.party.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Issa Fikadu
 */

@Configuration
@ComponentScan(basePackages = "edu.mum.fincom.creditcard.*")
public class CreditCardAppConfig {

}
