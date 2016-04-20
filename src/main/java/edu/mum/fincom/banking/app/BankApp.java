package edu.mum.fincom.banking.app;

import edu.mum.fincom.banking.BankAppConfig;
import edu.mum.fincom.banking.account.AccountType;
import edu.mum.fincom.banking.factory.BankAccountFactory;
import edu.mum.fincom.banking.factory.BankFactory;
import edu.mum.fincom.banking.factory.BankTransactionFactory;
import edu.mum.fincom.banking.factory.TransactionType;
import edu.mum.fincom.framework.FinComApp;
import edu.mum.fincom.framework.IAccount;
import edu.mum.fincom.framework.factory.FinComFactory;
import edu.mum.fincom.framework.party.Address;
import edu.mum.fincom.framework.party.ICustomer;
import edu.mum.fincom.framework.party.Organization;
import edu.mum.fincom.framework.party.Person;
import edu.mum.fincom.framework.service.AccountService;
import edu.mum.fincom.framework.service.SimpleServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import viewFramework.ApplicationFrame;

import java.util.Date;

/**
 * @author Issa Fikadu
 */
@Component
public class BankApp extends FinComApp
{
    static public void main(String args[])
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(BankAppConfig.class);
        BankApp app = (BankApp) context.getBean("bankApp");
        app.appFrame.startFrame();
    }


    @Override
    public ApplicationFrame getFrame() {
        return new BankFrame(this);
    }

    @Autowired
    BankFactory bankFactory;


    @Autowired
    public BankApp(FinComFactory bankFactory) {
        super(bankFactory);
    }

    public void createPersonalCheckingAccount(){
        ICustomer customer = new Person(appFrame.clientName,new Address(appFrame.street,appFrame.city, appFrame.state,
                Integer.parseInt(appFrame.zip),appFrame.email),new Date());

        BankAccountFactory bankAccountFactory = new BankAccountFactory(AccountType.CHECKING,customer);
        bankFactory.setAccountFactory(bankAccountFactory);
        createAccount();
    }

    public void createPersonalSavingAccount(){
        ICustomer customer = new Person(appFrame.clientName,new Address(appFrame.street,appFrame.city, appFrame.state,
                Integer.parseInt(appFrame.zip),appFrame.email),new Date());

        BankAccountFactory bankAccountFactory = new BankAccountFactory(AccountType.SAVING,customer);
        bankFactory.setAccountFactory(bankAccountFactory);
        createAccount();
    }

    public void createOrganizationSavingAccount(){
        ICustomer customer = new Organization(appFrame.clientName,new Address(appFrame.street,appFrame.city, appFrame.state,
                Integer.parseInt(appFrame.zip),appFrame.email),appFrame.numOfEmps);

        BankAccountFactory bankAccountFactory = new BankAccountFactory(AccountType.SAVING,customer);
        bankFactory.setAccountFactory(bankAccountFactory);
        createAccount();
    }

    public void createOrganizationCheckingAccount(){
        ICustomer customer = new Organization(appFrame.clientName,new Address(appFrame.street,appFrame.city, appFrame.state,
                Integer.parseInt(appFrame.zip),appFrame.email),appFrame.numOfEmps);

        BankAccountFactory bankAccountFactory = new BankAccountFactory(AccountType.CHECKING,customer);
        bankFactory.setAccountFactory(bankAccountFactory);
        createAccount();
    }

    public void deposit(String accnm, long val){
        IAccount account = null;
        double amount = Double.valueOf(val);
        AccountService ser = SimpleServiceFactory.getAccountService();
        account = ser.getAccountByName(accnm);

        System.out.println(account.getBalance());
        BankTransactionFactory transactionFactory = new BankTransactionFactory(TransactionType.DEPOSIT,account, amount);
        bankFactory.setTransactionFactory(transactionFactory);
        createTransaction();

    }


    public double withdraw(String accnm, long val){
        IAccount account = null;
        double amount = Double.valueOf(val);
        AccountService ser = SimpleServiceFactory.getAccountService();
        account = ser.getAccountByName(accnm);

        System.out.println(account.getBalance());
        BankTransactionFactory transactionFactory = new BankTransactionFactory(TransactionType.WITHDRAWAL,account, amount);
        transactionFactory.createTransaction().execute();

        System.out.println(account.getBalance());

      //  notifyObservers();
        return account.getBalance();
    }

    public void createSavingAccount(){
     //   bankFactory.setAccountFactory(savingAccountFactory);

        // System.out.println("creating checking account");
       // IAccount account = checkingAccountFactory.createAccount();
        // System.out.println(account.getInterestRate());
        createAccount();
    }


}
