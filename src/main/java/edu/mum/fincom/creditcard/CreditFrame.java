package edu.mum.fincom.creditcard;

import edu.mum.fincom.creditcard.Customer.CreditCustomer;
import edu.mum.fincom.creditcard.app.CreditCard;
import edu.mum.fincom.framework.IAccount;
import edu.mum.fincom.framework.gui.ApplicationFrame;
import edu.mum.fincom.creditcard.app.DialogGenerateBill;
import edu.mum.fincom.framework.gui.AbstractDialogAddAccount;
import static edu.mum.fincom.creditcard.Constants.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class CreditFrame extends ApplicationFrame{

	private static final long serialVersionUID = 1L;

	public CreditCard creditCardapp;
	public String CCNumber,Exp_Date= "ee";
	public String acc_type;

	public CreditFrame(CreditCard ca){

		this.creditCardapp = ca;
		this.creditCardapp.attach(this);
	}

	public List<String> getTableColumnNames()
	{
		List<String> tableColumnNames = new ArrayList<String>();
		tableColumnNames.add("Name");
		tableColumnNames.add("CCNumber");
		tableColumnNames.add("Exp Date");
		tableColumnNames.add("Type");
		tableColumnNames.add("Balance");

		return tableColumnNames;
	}

	@Override
	protected void createAccount(String accountType, String customerType) {

		if (customerType.equalsIgnoreCase(PERSONAL_ACCOUNT_TYPE)){//Personal Account
			if (accountType.equals(GOLD_ACCOUNT_TYPE)){
				creditCardapp.createPersonalGoldAccount();
			}else if (accountType.equals(BRONZE_ACCOUNT_TYPE)){
				creditCardapp.createPersonalBronzeAccount();
			}else if (accountType.equals(SILVER_ACCOUNT_TYPE)){
				creditCardapp.createPersonalSilverAccount();
			}
		}

	}

	@Override
	public String getButton1Text() {
		return "Add Credit account";
	}

	@Override
	public String getButton2Text() {
		return "Generate Monthly Bills";
	}

	@Override
	public String getButton3Text() {
		return "";
	}

	@Override
	public String getButton4Text() {
		return "Deposit";
	}

	@Override
	public String getButton5Text() {
		return "Charge";
	}

	@Override
	public String getFrameTitle() {
			return "Credit Application";
	}

	@Override
	public void interestButton(JPanel panel ,JButton interestButton) {
	}

	public String getDDTitle()
	{
		return "Deposit";
	}

	public String getWDTitle()
	{
		return "Charge Account";
	}

	@Override
	protected void processInterest() {

	}

	@Override
	public AbstractDialogAddAccount getAddingAccountDialog(String ACC_TYPE) {
		return new DialogAddCCA(this);
	}

	@Override
	protected void deposit(String accnr, long deposit) {
		creditCardapp.deposit(accnr, deposit);
	}

	@Override
	protected void withdraw(String accnr, long deposit) {
		creditCardapp.chargeMoney(accnr, deposit);
			}

	@Override
	public Vector<String> getVectorToAdd(IAccount account) {
		CreditCustomer customer= (CreditCustomer) account.getCustomer();
		Vector<String> vector = new Vector<>();
		vector.add(customer.getName());
		vector.add(customer.getCC_number());
		vector.add(customer.getExpiryDate());
		vector.add(account.getDescription());
		vector.add(String.valueOf(account.getBalance()));

		return vector;
	}

	@Override
	protected void JButton2_actionPerformed(java.awt.event.ActionEvent event)
	{
			new DialogGenerateBill().show();
	}

	@Override
	public String getSelectionString() {
		return this.acc_type;
	}


	@Override
	public void update() {
		refreshTable();
		System.out.println("Notifying JTable: Refresh");
		System.out.println(creditCardapp.getAccounts().size());
		for(IAccount i : creditCardapp.getAccounts())
			addRowToTable(getVectorToAdd(i));
	}
}
