package edu.mum.fincom.framework;

import edu.mum.fincom.framework.factory.AccountFactory;
import edu.mum.fincom.framework.factory.FinComFactory;
import edu.mum.fincom.framework.party.ICustomer;
import edu.mum.fincom.framework.service.SimpleServiceFactory;
import edu.mum.fincom.framework.transaction.ITransaction;
import viewFramework.ApplicationFrame;
import viewFramework.DefaultFrame;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Issa Fikadu
 */
public class FinCom implements ISubject {

    private List<IObserver> observers;

    private FinComFactory finComFactory;

    public ApplicationFrame appFrame;

//    public static void main(String args[]){
//        FinComApp app = new FinComApp();
//        app.appFrame.startFrame();
//    }

    public ApplicationFrame getFrame()
    {
        return new DefaultFrame();
    }
    public FinCom(FinComFactory finComFactory){
        this.finComFactory = finComFactory;
        observers = new ArrayList<>();
        this.appFrame = getFrame();
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

        SimpleServiceFactory.getAccountService().createAccount(account);

        notifyObservers();

    }

    public final void createCustomer(){
        ICustomer customer = finComFactory.createCustomerFactory().createCustomer();
        SimpleServiceFactory.getCustomerService().createCustomer(customer);
    }

    public final void createTransaction(){
        ITransaction transaction = finComFactory.createTransactionFactory().createTransaction();
        SimpleServiceFactory.getTransactionService().process(transaction);
        notifyObservers();

    }

    public List<IAccount> getAccounts(){
        return SimpleServiceFactory.getAccountService().getAccounts();
    }
}
