package edu.mum.fincom.creditcard;

import edu.mum.fincom.banking.account.AccountType;
import edu.mum.fincom.banking.factory.BankAccountFactory;
import edu.mum.fincom.banking.factory.BankFactory;
import edu.mum.fincom.banking.factory.BankTransactionFactory;
import edu.mum.fincom.banking.factory.TransactionType;
import edu.mum.fincom.framework.FinCom;
import edu.mum.fincom.framework.IAccount;
import edu.mum.fincom.framework.factory.FinComFactory;
import edu.mum.fincom.framework.party.Address;
import edu.mum.fincom.framework.party.ICustomer;
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
public class CreditCard extends FinCom
{
    static public void main(String args[])
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(CreditCardAppConfig.class);
        CreditCard app = (CreditCard) context.getBean("creditCardApp");
        app.appFrame.startFrame();
    }


    @Override
    public ApplicationFrame getFrame() {
        return new CreditFrame(this);
    }

    @Autowired
    BankFactory bankFactory;


    @Autowired
    public CreditCard(FinComFactory bankFactory) {
        super(bankFactory);
    }

    public void addCreditCardAccount(AccountType type){
        ICustomer customer = new Person(appFrame.clientName,new Address(appFrame.street,appFrame.city, appFrame.state,
                Integer.parseInt(appFrame.zip),appFrame.email),new Date());

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
        transactionFactory.createTransaction().execute();

        System.out.println(account.getBalance());

        notifyObservers();
    }


    public double chargeMoney(String accnm, long val){
        IAccount account = null;
        double amount = Double.valueOf(val);
        AccountService ser = SimpleServiceFactory.getAccountService();
        account = ser.getAccountByName(accnm);

        System.out.println(account.getBalance());
        BankTransactionFactory transactionFactory = new BankTransactionFactory(TransactionType.WITHDRAWAL,account, amount);
        transactionFactory.createTransaction().execute();

        System.out.println(account.getBalance());

        notifyObservers();
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
