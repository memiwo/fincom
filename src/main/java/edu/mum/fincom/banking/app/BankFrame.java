package edu.mum.fincom.banking.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;

import viewFramework.ApplicationFrame;
import viewFramework.JDialog_AddingAccount;

public class BankFrame extends ApplicationFrame{

	private static final long serialVersionUID = 1L;


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
	public void ThirdButton(JPanel panel ,JButton interestButton) {
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
	protected void createAccount() {
		associationClass.createPersonalCheckingAccount();
	}


	public String getDDTitle(){
		return "Deposit";
	}

	public String getWDTitle(){
		return "Withdraw";
	}

	@Override
	public JDialog_AddingAccount getAddingAccount() {
		return new DialogAddPA(this);
	}

	@Override
	public Vector<String> getVectorToAdd() {
		Vector<String> vector = new Vector<>();
		vector.add(clientName);
		vector.add(street);
		vector.add(city);
		vector.add(state);
		vector.add(zip);
		vector.add(pc);
		vector.add(chs);
		vector.add(balance);

		return vector;
	}

	@Override
	public int getAmountSelectionColumnNum() {
		return 7;
	}

}
