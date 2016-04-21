package edu.mum.fincom.framework.gui;

import edu.mum.fincom.banking.TransactionType;
import edu.mum.fincom.framework.FinCom;
import edu.mum.fincom.framework.IAccount;
import edu.mum.fincom.framework.IObserver;
import edu.mum.fincom.framework.factory.DefaultFinComFactory;
import edu.mum.fincom.framework.factory.FinComAccountFactory;
import edu.mum.fincom.framework.factory.FinComTransactionFactory;
import edu.mum.fincom.framework.factory.TransactionFactory;
import edu.mum.fincom.framework.party.Address;
import edu.mum.fincom.framework.party.ICustomer;
import edu.mum.fincom.framework.party.Organization;
import edu.mum.fincom.framework.party.Person;
import edu.mum.fincom.framework.transaction.DepositTransactionValidator;
import edu.mum.fincom.framework.transaction.WithdrawTransactionValidator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;


public class DefaultFrame extends ApplicationFrame implements IObserver{

	private FinCom finCom;

	public DefaultFrame(FinCom finCom){
		this.finCom = finCom;
		this.finCom.attach(this);
	}

	@Override
	protected void createAccount(String accountType, String customerType) {

		if (customerType.equalsIgnoreCase(PERSONAL_ACCOUNT_TYPE)){//Personal Account
			ICustomer customer = new Person(clientName,new Address(street,city, state,
					Integer.parseInt(zip),email),new Date());


			DefaultFinComFactory defaultFinComFactory = (DefaultFinComFactory) finCom.getFinComFactory();

			defaultFinComFactory.setAccountFactory(new FinComAccountFactory(customer));

			finCom.createAccount();

		}else if (customerType.equalsIgnoreCase(ORGANIZATION_ACCOUNT_TYPE)){//Organizational Account{
			ICustomer customer = new Organization(clientName,new Address(street,city, state,
					Integer.parseInt(zip),email),numOfEmps);


			DefaultFinComFactory defaultFinComFactory = (DefaultFinComFactory) finCom.getFinComFactory();
			defaultFinComFactory.setAccountFactory(new FinComAccountFactory(customer));

			finCom.createAccount();
		}
	}

	@Override
	public Vector<String> getVectorToAdd(IAccount account) {
		Vector<String> vector = new Vector<>();
		vector.add(account.getCustomer().getName());
		vector.add(account.getCustomer().getAddress().getStreet());
		vector.add(account.getCustomer().getAddress().getCity());
		vector.add(account.getCustomer().getAddress().getState());
		vector.add(String.valueOf(account.getCustomer().getAddress().getZip()));
		vector.add(account.getCustomer().getClass().getSimpleName());
		vector.add(String.valueOf(account.getBalance()));

		return vector;
	}

	@Override
	public AbstractDialogAddAccount getAddingAccountDialog() {
		return new DefaultDialogAddPA(this);
	}

	@Override
	protected void deposit(String accnr, long deposit) {
		IAccount account = finCom.getAccountByName(accnr);
		double amount = Double.valueOf(deposit);
		TransactionFactory transactionFactory = new FinComTransactionFactory(TransactionType.DEPOSIT, account, amount, new DepositTransactionValidator(500));

		DefaultFinComFactory defaultFinComFactory = (DefaultFinComFactory) finCom.getFinComFactory();
		defaultFinComFactory.setTransactionFactory(transactionFactory);

		finCom.createTransaction();

	}

	@Override
	protected void withdraw(String accnr, long deposit) {
		IAccount account = finCom.getAccountByName(accnr);
		double amount = Double.valueOf(deposit);

		TransactionFactory transactionFactory = new FinComTransactionFactory(TransactionType.WITHDRAWAL, account, amount, new WithdrawTransactionValidator(500));

		DefaultFinComFactory defaultFinComFactory = (DefaultFinComFactory) finCom.getFinComFactory();
		defaultFinComFactory.setTransactionFactory(transactionFactory);

		finCom.createTransaction();
	}


	@Override
	protected void processInterest() {

	}

	@Override
	public void update() {
		refreshTable();
		System.out.println("Notifying JTable: Refresh");
		System.out.println(finCom.getAccounts().size());
		for(IAccount i : finCom.getAccounts())
			addRowToTable(getVectorToAdd(i));
	}

	public List<String> getTableColumnNames()
	{
		List<String> tableColumnNames = new ArrayList<String>();
		tableColumnNames.add("Name");
		tableColumnNames.add("Street");
		tableColumnNames.add("CIty");
		tableColumnNames.add("State");
		tableColumnNames.add("Zip");
		tableColumnNames.add("P/C");
		tableColumnNames.add("Amount");

		return tableColumnNames;
	}


	@Override
	public String getButton1Text() {
		return "Add personal account";
	}

	@Override
	public String getButton2Text() {
		return "Add Company Account";
	}
	@Override
	public String getButton3Text() {
		return "Add Interest";
	}

	@Override
	public String getButton4Text() {
		return "Deposit";
	}

	@Override
	public String getButton5Text() {
		return "Withdraw";
	}

	@Override
	public String getFrameTitle() {
		return "FinCom Application";
	}
}
