package edu.mum.fincom.banking.app;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JRadioButton;

import edu.mum.fincom.framework.gui.ApplicationFrame;
import edu.mum.fincom.framework.gui.AbstractDialogAddAccount;

public class DialogAddCA extends AbstractDialogAddAccount
{
	public DialogAddCA(ApplicationFrame myframe) {
		super(myframe);
	}

	public  String getDialogTitle(){
		return "Add Company  Account ";
	}

	@Override
	public List<JRadioButton> getRadioButtons() {
		List<JRadioButton> radioButtons = new ArrayList<JRadioButton>();

		JRadioButton JRadioButton_Chk = new JRadioButton();
		JRadioButton JRadioButton_Sav = new JRadioButton();

		JRadioButton_Chk.setText("Checkings");
		JRadioButton_Chk.setBounds(36,12,84,24);
		JRadioButton_Sav.setText("Savings");
		JRadioButton_Sav.setBounds(36,36,84,24);

		radioButtons.add(JRadioButton_Sav);
		radioButtons.add(JRadioButton_Chk);
		return radioButtons;
	}

	@Override
	public List<String> getadditionalLable() {
		List<String> list = new ArrayList<>();
		list.add("No of Employees");

		return list;
	}

}
