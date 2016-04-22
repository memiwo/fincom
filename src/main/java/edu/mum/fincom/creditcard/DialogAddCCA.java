package edu.mum.fincom.creditcard;

import edu.mum.fincom.framework.gui.ApplicationFrame;
import edu.mum.fincom.framework.gui.AbstractDialogAddAccount;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import static edu.mum.fincom.creditcard.Constants.*;

public class DialogAddCCA extends AbstractDialogAddAccount
{
	/**
	 *
	 */
	CreditFrame creditFrame;

	private static final long serialVersionUID = 1L;

	static JRadioButton JRadioButton_gold = new JRadioButton();
	static JRadioButton JRadioButton_Silver = new JRadioButton();
	static JRadioButton JRadioButton_bronze = new JRadioButton();


	public DialogAddCCA(ApplicationFrame myframe) {
		super(myframe);
		this.creditFrame =(CreditFrame) myframe;

		JRadioButton_gold.setText(GOLD_ACCOUNT_TYPE);
		JRadioButton_gold.setBounds(36,5,84,24);
		JRadioButton_gold.setSelected(true);

		JRadioButton_Silver.setText(SILVER_ACCOUNT_TYPE);
		JRadioButton_Silver.setBounds(36,30,84,24);

		JRadioButton_bronze.setText(BRONZE_ACCOUNT_TYPE);
		JRadioButton_bronze.setBounds(36,50,84,24);
	}

	public  String getDialogTitle()
	{
		return "Add Add Credit-Card  Account ";
	}

	@Override
	public List<JRadioButton> getRadioButtons() {
		List<JRadioButton> radioButtons = new ArrayList<JRadioButton>();

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
	public void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
	{
		parentframe.clientName = JTextField_NAME.getText();
		parentframe.street = JTextField_STR.getText();
		parentframe.city = JTextField_CT.getText();
		parentframe.zip = JTextField_ZIP.getText();
		parentframe.state = JTextField_ST.getText();
		parentframe.email = JTextField_EM.getText();
		creditFrame.CCNumber = JTextField_additional1.getText();
		parentframe.balance = "0";


		for(JRadioButton radioButton : getRadioButtons())
		{
			if (radioButton.isSelected())
			{
				creditFrame.acc_type= String.valueOf(radioButton.getText());
			}
		}

		parentframe.newaccount=true;
		dispose();

	}

}
