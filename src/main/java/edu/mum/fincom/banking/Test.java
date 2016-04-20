package edu.mum.fincom.banking;

import edu.mum.fincom.banking.app.BankApp;
import edu.mum.fincom.framework.IAccount;
import edu.mum.fincom.framework.IObserver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Issa Fikadu
 */
public class Test implements IObserver {
    BankApp bankApp;
    public static void main(String[] args) {
        Test test = new Test();
        ApplicationContext context = new AnnotationConfigApplicationContext(BankAppConfig.class);
        BankApp app = (BankApp) context.getBean("bankApp");
        test.bankApp = app;
        app.attach(test);
       // BankFactory factory = (BankFactory) context.getBean("bankFactory");
        app.createPersonalCheckingAccount();
      //  System.out.println(app.createCheckingAccount());

    }

    @Override
    public void update() {
        for(IAccount account :bankApp.getAccounts()){
            System.out.println("Account "+account.getCustomer().getName());
        }
    }
}
