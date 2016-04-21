package edu.mum.fincom.banking.app;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JRadioButton;

import edu.mum.fincom.framework.gui.ApplicationFrame;
import edu.mum.fincom.framework.gui.DefaultDialogAddPA;
import static edu.mum.fincom.banking.Constants.*;

public class DialogAddPA extends DefaultDialogAddPA
{
	private static final long serialVersionUID = 1L;

	static JRadioButton JRadioButton_Chk = new JRadioButton();
	static JRadioButton JRadioButton_Sav = new JRadioButton();

	public DialogAddPA(ApplicationFrame myframe) {
		super(myframe);
		JRadioButton_Chk.setText(CHECKING_ACCOUNT_TYPE);
	//	JRadioButton_Chk.setActionCommand("Checkings");
		JRadioButton_Chk.setBounds(36,12,84,24);
		JRadioButton_Chk.setSelected(true);

		JRadioButton_Sav.setText(SAVING_ACCOUNT_TYPE);

		//JRadioButton_Sav.setActionCommand("Savings");
		JRadioButton_Sav.setBounds(36,36,84,24);

	}

	public  String getDialogTitle()
	{
		return "Add Personal  Account ";
	}

	@Override
	public List<JRadioButton> getRadioButtons() {
		List<JRadioButton> radioButtons = new ArrayList<JRadioButton>();
		radioButtons.add(JRadioButton_Chk);
		radioButtons.add(JRadioButton_Sav);
		return radioButtons;
	}

}
