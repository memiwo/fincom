package edu.mum.fincom.framework.gui;

import edu.mum.fincom.framework.FinCom;
import edu.mum.fincom.framework.IAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class DefaultFrame extends ApplicationFrame{

	private FinCom finCom;

	public DefaultFrame(FinCom finCom){
		this.finCom = finCom;
	}

	@Override
	protected void createAccount(String accountType, String customerType) {

	}

	@Override
	public Vector<String> getVectorToAdd(IAccount a) {
		return null;
	}

	@Override
	public AbstractDialogAddAccount getAddingAccountDialog() {
		return new DefaultDialogAddPA(this);
	}

	@Override
	protected void deposit(String accnr, long deposit) {

	}

	@Override
	protected void withdraw(String accnr, long deposit) {

	}


	@Override
	protected void processInterest() {

	}

	@Override
	public void update() {

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
