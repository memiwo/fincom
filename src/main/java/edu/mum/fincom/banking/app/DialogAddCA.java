package edu.mum.fincom.banking.app;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JRadioButton;

import edu.mum.fincom.framework.gui.ApplicationFrame;
import edu.mum.fincom.framework.gui.AbstractDialogAddAccount;
import edu.mum.fincom.framework.gui.DefaultDialogAddCA;

import static edu.mum.fincom.banking.Constants.CHECKING_ACCOUNT_TYPE;
import static edu.mum.fincom.banking.Constants.SAVING_ACCOUNT_TYPE;

public class DialogAddCA extends DefaultDialogAddCA
{

	static JRadioButton JRadioButton_Chk = new JRadioButton();
	static JRadioButton JRadioButton_Sav = new JRadioButton();

	public DialogAddCA(ApplicationFrame myframe) {
		super(myframe);
		JRadioButton_Chk.setText(CHECKING_ACCOUNT_TYPE);

		JRadioButton JRadioButton_Chk = new JRadioButton();
		JRadioButton JRadioButton_Sav = new JRadioButton();

		JRadioButton_Chk.setText("Checkings");
		JRadioButton_Chk.setBounds(36,12,84,24);
		JRadioButton_Chk.setSelected(true);

		JRadioButton_Sav.setText(SAVING_ACCOUNT_TYPE);

		JRadioButton_Sav.setText("Savings");
		JRadioButton_Sav.setBounds(36,36,84,24);
	}

	public  String getDialogTitle(){
		return "Add Company  Account ";
	}


	@Override
	public List<JRadioButton> getRadioButtons() {
		List<JRadioButton> radioButtons = new ArrayList<>();
		radioButtons.add(JRadioButton_Chk);
		radioButtons.add(JRadioButton_Sav);
		return radioButtons;
	}
}
