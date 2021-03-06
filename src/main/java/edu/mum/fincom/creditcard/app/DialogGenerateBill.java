package edu.mum.fincom.creditcard.app;
/*
		A basic implementation of the JDialog class.
*/

import java.awt.*;
import javax.swing.*;

public class DialogGenerateBill extends JDialog
{
    String billstring;

   public  String  Name, address, ccnum, cctype, prevbal, totalCredit, totalCharge,newBal, totalAmtDue;
	public DialogGenerateBill(Frame parent)
	{
		super(parent);

		getContentPane().setLayout(null);
		setSize(405,367);
		setVisible(false);
		getContentPane().add(JScrollPane1);
		JScrollPane1.setBounds(24,24,358,240);
		JScrollPane1.getViewport().add(JTextField1);
		JTextField1.setBounds(0,0,355,237);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(156,276,96,24);

		// generate the string for the monthly bill

		String wName, waddress, wccnum, wcctype, wprevbal, wtotalCredit, wtotalCharge,wnewBal, wtotalAmtDue;

		wName = "Name= "+Name+"\n";
		waddress =  "Address = "+address+"\n";
		wccnum = "CC number = "+ccnum+"\n";
		wcctype = "CC type = " + cctype+"\n";
		wprevbal = "Previous Balance = " + prevbal+"\n";
		wtotalCredit = "Total Credit =  "+totalCredit+"\n";
		wtotalCharge = "Total Charges = " + totalCharge+"\n";
		wnewBal = "New Balance = "+ newBal+"\n";
		wtotalAmtDue = "Total Amount Due = "+ totalAmtDue+"\n";

		billstring = wName+ waddress+ wccnum+ wcctype+ wprevbal+ wtotalCredit+ wtotalCharge+wnewBal+ wtotalAmtDue;
		JTextField1.setText(billstring);
		System.out.println(billstring);
		//}}

		//{{REGISTER_LISTENERS
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		//}}
	}

	public DialogGenerateBill()
	{
		this((Frame)null);
	}



	//{{DECLARE_CONTROLS
	JScrollPane JScrollPane1 = new JScrollPane();
	JTextField JTextField1 = new JTextField();
	JButton JButton_OK = new JButton();
	//}}


	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
		}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
	{
		dispose();

	}
}
