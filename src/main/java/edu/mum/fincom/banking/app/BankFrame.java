package edu.mum.fincom.banking.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.mum.fincom.framework.IAccount;
import edu.mum.fincom.framework.gui.ApplicationFrame;
import edu.mum.fincom.framework.gui.AbstractDialogAddAccount;
import static edu.mum.fincom.banking.Constants.*;

public class BankFrame extends ApplicationFrame{

	private static final long serialVersionUID = 1L;

	public Bank bankApp;

	public BankFrame(Bank bankApp){

		this.bankApp = bankApp;
		this.bankApp.attach(this);
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
			return "Bank Application";
	}

	@Override
	public void interestButton(JPanel panel ,JButton interestButton) {
		panel.add(interestButton);
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
		tableColumnNames.add("Ch/S");
		tableColumnNames.add("Amount");

		return tableColumnNames;
	}

	@Override
	protected void createAccount(String accountType, String customerType) {

		if (customerType.equalsIgnoreCase(PERSONAL_ACCOUNT_TYPE)){//Personal Account
			if (accountType.equals(CHECKING_ACCOUNT_TYPE)){
				bankApp.createPersonalCheckingAccount();
			}else if (accountType.equals(SAVING_ACCOUNT_TYPE)){
				bankApp.createPersonalSavingAccount();
			}
		}else if (customerType.equalsIgnoreCase(ORGANIZATION_ACCOUNT_TYPE)){//Organizational Account{

			if (accountType.equals(CHECKING_ACCOUNT_TYPE)){

				bankApp.createOrganizationCheckingAccount();
			}else if (accountType.equals(SAVING_ACCOUNT_TYPE)){

				bankApp.createOrganizationSavingAccount();
			}
		}
	}


	public String getDDTitle(){
		return "Deposit";
	}

	public String getWDTitle(){
		return "Withdraw";
	}

	@Override
	protected void processInterest() {
		bankApp.addInterest();
	}

	@Override
	public AbstractDialogAddAccount getAddingAccountDialog(String ACC_TYPE) {
		if(ACC_TYPE.equalsIgnoreCase("O"))
			return new DialogAddCA(this);
			else if(ACC_TYPE.equalsIgnoreCase("P"))
			return new DialogAddPA(this);
		return new DialogAddPA(this);
	}

	@Override
	protected void deposit(String accnr, long deposit) {
		bankApp.deposit(accnr, deposit);
	}

	@Override
	protected void withdraw(String accnr, long amount) {
		 bankApp.withdraw(accnr, amount);
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
		vector.add(account.getDescription());
		vector.add(String.valueOf(account.getBalance()));

		return vector;
	}


	@Override
	public void update() {
		refreshTable();
		System.out.println("Notifying JTable: Refresh");
		System.out.println(bankApp.getAccounts().size());
		for(IAccount i : bankApp.getAccounts())
		addRowToTable(getVectorToAdd(i));
	}
}
