package CreditApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;

import viewFramework.ApplicationFrame;
import viewFramework.JDialogGenBill;
import viewFramework.JDialog_AddingAccount;

public class CreditFrame extends ApplicationFrame{

	private static final long serialVersionUID = 1L;

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
	protected void createAccount() {

	}

	@Override
	public String getButton1Text() {
		return "Add Credit account";
	}

	@Override
	public String getButton2Text() {
		// TODO Auto-generated method stub
		return "Generate Monthly Bills";
	}

	@Override
	public String getButton3Text() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String getButton4Text() {
		// TODO Auto-generated method stub
		return "Deposit";
	}

	@Override
	public String getButton5Text() {
		// TODO Auto-generated method stub
		return "Charge";
	}

	@Override
	public String getFrameTitle() {
			return "Credit Application";
	}

	@Override
	public void ThirdButton(JPanel panel ,JButton interestButton) {
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
	public JDialog_AddingAccount getAddingAccount() {
		return new DialogAddCCA(this);
	}

	@Override
	public Vector<String> getVectorToAdd() {
		Vector<String> vector = new Vector<>();
		vector.add(clientName);
		vector.add(ccnumber);
		vector.add(expDate);
		vector.add(accountType);
		vector.add(balance);

		return vector;
	}

	@Override
	protected void JButton2_actionPerformed(java.awt.event.ActionEvent event)
	{
			new JDialogGenBill().show();
	}

	@Override
	public int getAmountSelectionColumnNum() {
		return 4;
	}

}
