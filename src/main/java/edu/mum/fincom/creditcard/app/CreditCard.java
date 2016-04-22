package edu.mum.fincom.creditcard.app;

import edu.mum.fincom.creditcard.factory.TransactionType;
import edu.mum.fincom.creditcard.CreditCardAppConfig;
import edu.mum.fincom.creditcard.CreditFrame;
import edu.mum.fincom.creditcard.Customer.CreditCustomer;
import edu.mum.fincom.creditcard.factory.CreditCardAccountFactory;
import edu.mum.fincom.creditcard.factory.CreditCardFactory;
import edu.mum.fincom.creditcard.factory.CreditCardTransactionFactory;
import edu.mum.fincom.framework.FinCom;
import edu.mum.fincom.framework.IAccount;
import edu.mum.fincom.framework.factory.FinComFactory;
import edu.mum.fincom.framework.gui.ApplicationFrame;
import edu.mum.fincom.framework.party.Address;
import edu.mum.fincom.framework.party.ICustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author Issa Fikadu
 */
@Component
public class CreditCard extends FinCom
{
    public CreditFrame creditFrame = (CreditFrame) appFrame;
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


    public void deposit(String accnm, long val){
        IAccount account = getAccountByName(accnm);
        double amount = Double.valueOf(val);

        CreditCardTransactionFactory transactionFactory = new CreditCardTransactionFactory(TransactionType.DEPOSIT,account, amount);
        creditCardFactory.setTransactionFactory(transactionFactory);

        createTransaction();
    }


    public double chargeMoney(String accnm, long val){
        IAccount account = getAccountByName(accnm);
        double amount = Double.valueOf(val);

        CreditCardTransactionFactory transactionFactory = new CreditCardTransactionFactory(TransactionType.WITHDRAWAL,account, amount);
        creditCardFactory.setTransactionFactory(transactionFactory);

        createTransaction();
        return 0;
    }


    public void createPersonalGoldAccount() {
        ICustomer customer = new CreditCustomer(appFrame.clientName,new Address(appFrame.street,appFrame.city, appFrame.state,
                Integer.parseInt(appFrame.zip),appFrame.email),appFrame.numOfEmps,this.creditFrame.CCNumber, this.creditFrame.Exp_Date);

        CreditCardAccountFactory creditAccountFactory = new CreditCardAccountFactory(edu.mum.fincom.creditcard.account.AccountType.GOLD,customer);
        creditCardFactory.setAccountFactory(creditAccountFactory);
        createAccount();
    }

    public void createPersonalBronzeAccount() {
        ICustomer customer = new CreditCustomer(appFrame.clientName,new Address(appFrame.street,appFrame.city, appFrame.state,
                Integer.parseInt(appFrame.zip),appFrame.email),appFrame.numOfEmps,this.creditFrame.CCNumber, this.creditFrame.Exp_Date);

        CreditCardAccountFactory creditAccountFactory = new CreditCardAccountFactory(edu.mum.fincom.creditcard.account.AccountType.BRONZE,customer);
        creditCardFactory.setAccountFactory(creditAccountFactory);
        createAccount();
    }

    public void createPersonalSilverAccount() {
        ICustomer customer = new CreditCustomer(appFrame.clientName,new Address(appFrame.street,appFrame.city, appFrame.state,
                Integer.parseInt(appFrame.zip),appFrame.email),appFrame.numOfEmps,this.creditFrame.CCNumber, this.creditFrame.Exp_Date);

        CreditCardAccountFactory creditAccountFactory = new CreditCardAccountFactory(edu.mum.fincom.creditcard.account.AccountType.SILVER,customer);
        creditCardFactory.setAccountFactory(creditAccountFactory);
        createAccount();
    }

}
