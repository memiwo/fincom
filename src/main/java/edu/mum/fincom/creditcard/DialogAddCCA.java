package edu.mum.fincom.creditcard;

import viewFramework.ApplicationFrame;
import viewFramework.JDialog_AddingAccount;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class DialogAddCCA extends JDialog_AddingAccount
{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public DialogAddCCA(ApplicationFrame myframe) {
		super(myframe);
	}

	public  String getDialogTitle()
	{
		return "Add Add Credit-Card  Account ";
	}

	@Override
	public List<JRadioButton> getRadioButtons() {
		List<JRadioButton> radioButtons = new ArrayList<JRadioButton>();

		JRadioButton JRadioButton_gold = new JRadioButton();
		JRadioButton JRadioButton_Silver = new JRadioButton();
		JRadioButton JRadioButton_bronze = new JRadioButton();

		JRadioButton_gold.setText("Gold");
		JRadioButton_gold.setActionCommand("Gold");
		JRadioButton_gold.setBounds(36,5,84,24);

		JRadioButton_Silver.setText("Silver");
		JRadioButton_Silver.setActionCommand("Silver");
		JRadioButton_Silver.setBounds(36,30,84,24);

		JRadioButton_bronze.setText("Bronze");
		JRadioButton_bronze.setActionCommand("Bronze");
		JRadioButton_bronze.setBounds(36,50,84,24);

		radioButtons.add(JRadioButton_gold);
		radioButtons.add(JRadioButton_Silver);
		radioButtons.add(JRadioButton_bronze);

		return radioButtons;
	}

	@Override
	public List<String> getadditionalLable() {
		List<String> list = new ArrayList<>();
		list.add("CCNumber");
		list.add("Exp Date");

		return list;
	}

	@Override
	public void additionalOK_actionPerformed() {

		parentframe.ccnumber = JTextField_EM.getText().toString();
		parentframe.expDate =  getTextFields().get(0).getText().toString();
		parentframe.accountType = "Gold";
	}

}
