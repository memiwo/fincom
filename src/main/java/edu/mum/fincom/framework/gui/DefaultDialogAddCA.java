package edu.mum.fincom.framework.gui;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class DefaultDialogAddCA extends AbstractDialogAddAccount
{
	public DefaultDialogAddCA(ApplicationFrame myframe) {
		super(myframe);
	}

	public  String getDialogTitle(){
		return "Add Company  Account ";
	}

	@Override
	public List<JRadioButton> getRadioButtons() {
		List<JRadioButton> radioButtons = new ArrayList<JRadioButton>();
		return radioButtons;
	}

	@Override
	public List<String> getadditionalLable() {
		List<String> list = new ArrayList<>();
		list.add("No of Employees");

		return list;
	}

}
