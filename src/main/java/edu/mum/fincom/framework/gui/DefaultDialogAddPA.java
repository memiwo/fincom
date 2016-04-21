package edu.mum.fincom.framework.gui;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class DefaultDialogAddPA extends AbstractDialogAddAccount
{
	private static final long serialVersionUID = 1L;

	public DefaultDialogAddPA(ApplicationFrame myframe) {
		super(myframe);
	}

	public  String getDialogTitle()
	{
		return "Add Personal  Account ";
	}

	@Override
	public List<JRadioButton> getRadioButtons() {
		List<JRadioButton> radioButtons = new ArrayList<JRadioButton>();
		return radioButtons;
	}

	@Override
	public List<String> getadditionalLable() {
		List<String> list = new ArrayList<>();
		list.add("Birthdate");

		return list;
	}
}
