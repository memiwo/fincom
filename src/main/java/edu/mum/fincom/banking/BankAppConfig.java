package edu.mum.fincom.banking;

import edu.mum.fincom.banking.account.CheckingAccount;
import edu.mum.fincom.framework.IAccount;
import edu.mum.fincom.framework.party.Address;
import edu.mum.fincom.framework.party.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Issa Fikadu
 */

@Configuration
@ComponentScan(basePackages = "edu.mum.fincom.banking..*")
public class BankAppConfig {

}
