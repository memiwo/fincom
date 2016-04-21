package edu.mum.fincom.creditcard.app;

import edu.mum.fincom.banking.account.AccountType;
import edu.mum.fincom.creditcard.CreditCardAppConfig;
import edu.mum.fincom.creditcard.CreditFrame;
import edu.mum.fincom.creditcard.factory.CreditCardAccountFactory;
import edu.mum.fincom.creditcard.factory.CreditCardFactory;
import edu.mum.fincom.framework.FinCom;
import edu.mum.fincom.framework.factory.FinComFactory;
import edu.mum.fincom.framework.party.Address;
import edu.mum.fincom.framework.party.ICustomer;
import edu.mum.fincom.framework.party.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import edu.mum.fincom.framework.gui.ApplicationFrame;

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
        CreditCard app = (CreditCard) context.getBean("creditCard");
        app.appFrame.startFrame();
    }


    @Override
    public ApplicationFrame getFrame() {
        return new CreditFrame(this);
    }

    @Autowired
    CreditCardFactory creditCardFactory;


    @Autowired
    public CreditCard(FinComFactory creditCardFactory) {
        super(creditCardFactory);
    }

    public void addCreditCardAccount(AccountType type){
        ICustomer customer = new Person(appFrame.clientName,new Address(appFrame.street,appFrame.city, appFrame.state,
                Integer.parseInt(appFrame.zip),appFrame.email),new Date());

        CreditCardAccountFactory creditCardAccountFactory = new CreditCardAccountFactory(AccountType.CHECKING,customer);
        creditCardFactory.setAccountFactory(creditCardAccountFactory);
        createAccount();
    }


    public void deposit(String accnm, long val){
       /* IAccount account = null;
        double amount = Double.valueOf(val);
        AccountService ser = SimpleServiceFactory.getAccountService();
        account = ser.getAccountByName(accnm);

        System.out.println(account.getBalance());
        BankTransactionFactory transactionFactory = new BankTransactionFactory(TransactionType.DEPOSIT,account, amount);
        transactionFactory.createTransaction().execute();

        System.out.println(account.getBalance());

        notifyObservers();*/
    }


    public double chargeMoney(String accnm, long val){
        /*IAccount account = null;
        double amount = Double.valueOf(val);
        AccountService ser = SimpleServiceFactory.getAccountService();
        account = ser.getAccountByName(accnm);

        System.out.println(account.getBalance());
        BankTransactionFactory transactionFactory = new BankTransactionFactory(TransactionType.WITHDRAWAL,account, amount);
        transactionFactory.createTransaction().execute();

        System.out.println(account.getBalance());

        notifyObservers();
        return account.getBalance();*/
        return 0;
    }

    public void createSavingAccount(){
        //   bankFactory.setAccountFactory(savingAccountFactory);

        // System.out.println("creating checking account");
        // IAccount account = checkingAccountFactory.createAccount();
        // System.out.println(account.getInterestRate());
        createAccount();
    }


    public void createPersonalGoldAccount() {
    }

    public void createPersonalBronzeAccount() {
    }

    public void createPersonalSilverAccount() {
    }

    public void createOrganizationGoldAccount() {
    }

    public void createOrganizationBronzeAccount() {
    }

    public void createOrganizationSilverAccount() {

    }
}
