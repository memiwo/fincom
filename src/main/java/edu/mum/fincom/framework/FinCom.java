package edu.mum.fincom.framework;

import edu.mum.fincom.framework.factory.DefaultFinComFactory;
import edu.mum.fincom.framework.factory.FinComFactory;
import edu.mum.fincom.framework.party.ICustomer;
import edu.mum.fincom.framework.service.AccountService;
import edu.mum.fincom.framework.service.CustomerService;
import edu.mum.fincom.framework.service.SimpleServiceFactory;
import edu.mum.fincom.framework.transaction.ITransaction;
import edu.mum.fincom.framework.gui.ApplicationFrame;
import edu.mum.fincom.framework.gui.DefaultFrame;
import edu.mum.fincom.framework.transaction.TransactionService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Issa Fikadu
 */
public class FinCom implements ISubject {

    private List<IObserver> observers;

    private FinComFactory finComFactory;

    public ApplicationFrame appFrame;

    private AccountService accountService;
    private CustomerService customerService;
    private TransactionService transactionService;

    public FinCom(FinComFactory finComFactory){

        this.finComFactory = finComFactory;
        observers = new ArrayList<>();
        this.appFrame = getFrame();
        this.accountService = SimpleServiceFactory.getAccountService();
        this.transactionService = SimpleServiceFactory.getTransactionService();
        this.customerService = SimpleServiceFactory.getCustomerService();
    }


    public static void main(String args[]){
        FinCom app = new FinCom(new DefaultFinComFactory());
        app.appFrame.startFrame();
    }

    public ApplicationFrame getFrame()
    {
        return new DefaultFrame(this);
    }

    @Override
    public void attach(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(IObserver::update);
    }

    public final void createAccount(){
        IAccount account = finComFactory.createAccountFactory().createAccount();

        this.accountService.createAccount(account);

        notifyObservers();

    }

    public final void createCustomer(){
        ICustomer customer = finComFactory.createCustomerFactory().createCustomer();
       this.customerService.createCustomer(customer);
    }

    public final void createTransaction(){
        ITransaction transaction = finComFactory.createTransactionFactory().createTransaction();
        this.transactionService.process(transaction);
        notifyObservers();

    }

    public List<IAccount> getAccounts(){
        return SimpleServiceFactory.getAccountService().getAccounts();
    }

    public void addInterest(){
        this.accountService.addInterest();
        notifyObservers();

    }

    public IAccount getAccountByName(String name){
        return this.accountService.getAccountByName(name);
    }
}
