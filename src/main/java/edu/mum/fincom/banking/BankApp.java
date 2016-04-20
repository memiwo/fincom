package edu.mum.fincom.banking;

import edu.mum.fincom.banking.account.CheckingAccount;
import edu.mum.fincom.framework.FinComApp;
import edu.mum.fincom.framework.IAccount;
import edu.mum.fincom.framework.factory.FinComFactory;
import edu.mum.fincom.framework.party.Address;
import edu.mum.fincom.framework.party.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author Issa Fikadu
 */
@Component(value = "bankApp")

@Configuration
@ComponentScan(basePackages = "edu.mum.fincom.banking.*")
public class BankApp extends FinComApp {
    @Autowired
    IAccount checkingAccount;

    @Autowired
    FinComFactory bankFactory;

    public BankApp(FinComFactory finComFactory) {
        super(finComFactory);
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BankApp.class);
        BankApp app = (BankApp) context.getBean("bankApp");

        System.out.println(app.checkingAccount.getBalance());

    }
    @Bean
    IAccount checkingAccount(){
        return new CheckingAccount(new Person("Zeelo", new Address("","","",0,""),null));
    }
}
