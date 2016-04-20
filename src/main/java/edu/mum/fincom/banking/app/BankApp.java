package edu.mum.fincom.banking.app;

import edu.mum.fincom.banking.BankAppConfig;
import edu.mum.fincom.banking.factory.BankFactory;
import edu.mum.fincom.banking.factory.CheckingAccountFactory;
import edu.mum.fincom.banking.factory.SavingAccountFactory;
import edu.mum.fincom.framework.FinComApp;
import edu.mum.fincom.framework.IAccount;
import edu.mum.fincom.framework.factory.FinComFactory;
import edu.mum.fincom.framework.party.Address;
import edu.mum.fincom.framework.party.ICustomer;
import edu.mum.fincom.framework.party.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import viewFramework.ApplicationFrame;
import viewFramework.AssociationClass;

import java.util.Date;
import java.util.Vector;

/**
 * @author Issa Fikadu
 */
@Component
public class BankApp extends FinComApp implements AssociationClass
{
    static public void main(String args[])
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(BankAppConfig.class);
        BankApp app = (BankApp) context.getBean("bankApp");
        app.appFrame.startFrame(app);
        app.appFrame.setApplication(app);
    }

    @Override
    public ApplicationFrame getFrame() {
        return new BankFrame();
    }

    @Autowired
    BankFactory bankFactory;

    @Autowired
    CheckingAccountFactory checkingAccountFactory;

    @Autowired
    SavingAccountFactory savingAccountFactory;

    @Autowired
    public BankApp(FinComFactory bankFactory) {
        super(bankFactory);
    }


    public void createPersonalCheckingAccount()
    {
        ICustomer customer = new Person(appFrame.clientName,
                new Address(appFrame.street,appFrame.street, appFrame.state,Integer.parseInt(appFrame.zip),appFrame.email),new Date());

        System.out.println(customer);
        checkingAccountFactory.setCustomer(customer);
        bankFactory.setAccountFactory(checkingAccountFactory);

       // System.out.println("creating checking account");
        IAccount account = checkingAccountFactory.createAccount();
       // System.out.println(account.getInterestRate());
        createAccount();
    }

    public void createPersonalSavingAccount(){

    }

    public void createOrganizationSavingAccount(){

    }

    public void createOrganizationCheckingAccount(){

    }

    public void createSavingAccount(){
        bankFactory.setAccountFactory(savingAccountFactory);

        // System.out.println("creating checking account");
       // IAccount account = checkingAccountFactory.createAccount();
        // System.out.println(account.getInterestRate());
        createAccount();

    }

   /* public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BankAppConfig.class);
      *//*  BankApp app = (BankApp) context.getBean("bankApp");
        BankFactory factory = (BankFactory) context.getBean("bankFactory");

        System.out.println(app.checkingAccount.getBalance());*//*

    }*/

}
