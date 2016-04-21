package viewFramework;

import edu.mum.fincom.banking.app.DialogAddCA;
import edu.mum.fincom.framework.FinCom;
import edu.mum.fincom.framework.IAccount;
import edu.mum.fincom.framework.IObserver;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * A basic JFC based application.
 */
public abstract class ApplicationFrame extends javax.swing.JFrame implements IObserver
{

	public FinCom application;

	private static final long serialVersionUID = 1L;
	/****
     * init variables in the object
     ****/
	public String clientName;
	public String street;
	public String city;
	public String zip;
	public String state;
	public String accountType;
	public String clientType;
	public int numOfEmps;
	public String email;

	public String pc;
	public String chs;
	public String balance;


	public String ccnumber;
	public String expDate;

	public String amountDeposit;
    public boolean newaccount;
    public DefaultTableModel model;
    private JTable JTable1;
    private JScrollPane JScrollPane1;
    public  ApplicationFrame myframe;

	JPanel JPanel1 = new JPanel();
	JButton JButton1 = new JButton();
	JButton JButton2 = new JButton();
	JButton JButton_Deposit = new JButton();
	JButton JButton_Withdraw = new JButton();
	JButton JButton3= new JButton();
	JButton JButton_Exit = new JButton();
///

	public void setApplication(FinCom app)
	{
		this.application = app;
	}

	public ApplicationFrame()
	{
		myframe = this;

		setFrameTitle();

		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0,0));
		setSize(585,320);
		setBounds(400,244,585,320);
		setVisible(false);
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0,0,575,310);
		/*
		/Add five buttons on the pane
		/for Adding personal account, Adding company account
		/Deposit, Withdraw and Exit from the system
		*/
        JScrollPane1 = new JScrollPane();
        model = new DefaultTableModel();
        JTable1 = new JTable(model);
        setColumnTitles();
        newaccount=false;


        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12,92,444,160);
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 420, 0);

		JButton1.setText(getButton1Text());
		JButton2.setText(getButton2Text());
		JButton3.setText(getButton3Text());
		JButton_Deposit.setText(getButton4Text());
		JButton_Withdraw.setText(getButton5Text());
		JButton_Exit.setText(getButton6Text());


		JButton1.setActionCommand("jbutton");
		JButton2.setActionCommand("jbutton");

		JButton1.setBounds(24,20,192,33);
		JButton2.setBounds(240,20,192,33);
		JButton3.setBounds(448,20,106,33);
		JButton_Deposit.setBounds(468,104,96,33);
		JButton_Withdraw.setBounds(468,164,96,33);
		JButton_Exit.setBounds(468,248,96,31);

		///

		addJButtonsToJPanel1();

		////
		// lineBorder1.setRoundedCorners(true);
		// lineBorder1.setLineColor(java.awt.Color.green);
		//$$ lineBorder1.move(24,312);


		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		JButton_Exit.addActionListener(lSymAction);
		JButton1.addActionListener(lSymAction);
		JButton2.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
		JButton3.addActionListener(lSymAction);

	}

    public String getButton1Text(){
	return "btn 1";
    }

    public String getButton2Text(){
	return "btn 2";
    }

    public String getButton3Text(){
	return "btn 3";
    }

    public String getButton4Text(){
	return "btn 4";
    }

    public  String getButton5Text(){
	return "btn 5";
    }
    public String getButton6Text(){
	return "Exit";
    }


private void addJButtonsToJPanel1() {
	JPanel1.add(JButton1);
	JPanel1.add(JButton2);

	ThirdButton(JPanel1, JButton3);

	JPanel1.add(JButton_Deposit);
	JPanel1.add(JButton_Withdraw);
	JPanel1.add(JButton_Exit);
}

public void ThirdButton(JPanel panel ,JButton interestButton) {
	panel.add(interestButton);
}

/////////
	private void setColumnTitles() {
		for(String s : getTableColumnNames())
			model.addColumn(s);
	}


	private void setFrameTitle() {
		setTitle(getFrameTitle());
	}


	public String getFrameTitle() {
		return "Def frame";
	}

	public List<String> getTableColumnNames() {

		List<String> tableColumnNames = new ArrayList<String>();
		for(int i=0; i<7;i++)
		tableColumnNames.add("col "+i);
		return tableColumnNames;
	}


	/*****************************************************
	 * The entry point for this application.
	 * Sets the Look and Feel to the System Look and Feel.
	 * Creates a new JFrame1 and makes it visible.
	 *****************************************************/
	public void startFrame()
	{
		try {
		    try {
		        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    }
		    catch (Exception e) {
		    }
			(this).setVisible(true);
		}
		catch (Throwable t) {
			t.printStackTrace();
			System.exit(1);
		}
	}

	void exitApplication()
	{
		try {
		    	this.setVisible(false);    // hide the Frame
		    	this.dispose();            // free the system resources
		    	System.exit(0);            // close the application
		} catch (Exception e) {
		}
	}

	class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowClosing(java.awt.event.WindowEvent event)
		{
			Object object = event.getSource();
			if (object == ApplicationFrame.this)
				BankFrm_windowClosing(event);
		}
	}

	void BankFrm_windowClosing(java.awt.event.WindowEvent event)
	{
		// to do: code goes here.

		BankFrm_windowClosing_Interaction1(event);
	}

	void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}

	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_Exit)
				JButtonExit_actionPerformed(event);
			else if (object == JButton1)
				JButton1_actionPerformed(event);
			else if (object == JButton2)
				JButton2_actionPerformed(event);
			else if (object == JButton_Deposit)
				JButtonDeposit_actionPerformed(event);
			else if (object == JButton_Withdraw)
				JButtonWithdraw_actionPerformed(event);
			else if (object == JButton3)
				JButton3_actionPerformed(event);

		}
	}

    //When the Exit button is pressed this code gets executed
    //this will exit from the system
    void JButtonExit_actionPerformed(java.awt.event.ActionEvent event)
	{
		System.exit(0);
	}


	protected void JButton1_actionPerformed(java.awt.event.ActionEvent event)
	{
		JDialog_AddingAccount pac = getAddingAccount();
		pac.setBounds(450, 220, 300, 350);
		pac.show();

		if (newaccount){
			createAccount(1);
            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
            newaccount=false;
        }

    }

	protected abstract void createAccount(int selection);

	protected  void JButton2_actionPerformed(java.awt.event.ActionEvent event)
	{

		JDialog_AddingAccount pac = new DialogAddCA(myframe);
		pac.setBounds(450, 220, 300, 350);
		pac.show();

		if (newaccount){
			createAccount(2);
			JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
            newaccount=false;
        }

	}

	abstract public Vector<String> getVectorToAdd(IAccount acc);

	public abstract JDialog_AddingAccount getAddingAccount();

	public void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event)
	{
	    // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >=0){
            String accnr = (String)model.getValueAt(selection, 0);

            JDialog_ForEntries dep = new JDialog_ForEntries(this, getDDTitle(), accnr);
		    dep.setBounds(430, 285, 275, 160);
		    dep.show();

            long deposit = Long.parseLong(amountDeposit);

			deposit(accnr, deposit);

		}

        else
  		  JOptionPane.showMessageDialog(JButton3, " Please select a customer "," Message",JOptionPane.PLAIN_MESSAGE);

	}

	protected abstract void deposit(String accnr, long deposit);
	protected abstract void withdraw(String accnr, long deposit);


	abstract public int getAmountSelectionColumnNum();

	public String getDDTitle()
	{
		return "";
	}


	public String getWDTitle()
	{
		return "";
	}

	void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event)
	{
	    // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >=0){
            String accnr = (String)model.getValueAt(selection, 0);

		    //Show the dialog for adding withdraw amount for the current mane
            JDialog_ForEntries dep = new JDialog_ForEntries(this, getWDTitle(),accnr);
		    dep.setBounds(430, 285, 275, 160);
		    dep.show();

		    // compute new amount
            long withdraw = Long.parseLong(amountDeposit);

			//double newamount =
					withdraw(accnr, withdraw);

		   /* if (newamount <0){
		       JOptionPane.showMessageDialog(JButton_Withdraw, " Account "+accnr+" : balance is negative: $"+String.valueOf(newamount)+" !","Warning: negative balance",JOptionPane.WARNING_MESSAGE);
		    }*/
		}

	}

	void JButton3_actionPerformed(java.awt.event.ActionEvent event)
	{
		  JOptionPane.showMessageDialog(JButton3, "Add interest to all accounts","Add interest to all accounts",JOptionPane.WARNING_MESSAGE);
			addInterest();
	}

	protected abstract void addInterest();

	public void addRowToTable(Vector<String> dataRow) {
		model.addRow(dataRow);
	}

	public void refreshTable()
	{
			model.setRowCount(0);
	}
}
