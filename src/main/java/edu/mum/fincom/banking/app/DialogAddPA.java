package edu.mum.fincom.banking.app;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JRadioButton;

import viewFramework.ApplicationFrame;
import viewFramework.JDialog_AddingAccount;

public class DialogAddPA extends JDialog_AddingAccount
{
	private static final long serialVersionUID = 1L;

	public DialogAddPA(ApplicationFrame myframe) {
		super(myframe);
	}

	public  String getDialogTitle()
	{
		return "Add Personal  Account ";
	}

	@Override
	public List<JRadioButton> getRadioButtons() {
		List<JRadioButton> radioButtons = new ArrayList<JRadioButton>();

		JRadioButton JRadioButton_Chk = new JRadioButton();
		JRadioButton JRadioButton_Sav = new JRadioButton();

		JRadioButton_Chk.setText("Checkings");
		JRadioButton_Chk.setActionCommand("Checkings");
		getContentPane().add(JRadioButton_Chk);
		JRadioButton_Chk.setBounds(36,12,84,24);
		JRadioButton_Sav.setText("Savings");
		JRadioButton_Sav.setActionCommand("Savings");
		getContentPane().add(JRadioButton_Sav);
		JRadioButton_Sav.setBounds(36,36,84,24);

		radioButtons.add(JRadioButton_Sav);
		radioButtons.add(JRadioButton_Chk);
		return radioButtons;
	}

	@Override
	public List<String> getadditionalLable() {
		List<String> list = new ArrayList<>();
		list.add("Birthdate");

		return list;
	}

	@Override
	public void additionalOK_actionPerformed() {
		parentframe.pc ="P";
		parentframe.chs ="S";
		parentframe.balance = "0";
	}

}
