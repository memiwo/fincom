package viewFramework;

import edu.mum.fincom.framework.IAccount;

import java.util.Vector;

public class DefaultFrame extends ApplicationFrame{

	@Override
	protected void createAccount(int s) {

	}

	@Override
	public Vector<String> getVectorToAdd(IAccount a) {
		return null;
	}

	@Override
	public JDialog_AddingAccount getAddingAccount() {
		return null;
	}

	@Override
	protected void deposit(String accnr, long deposit) {

	}

	@Override
	protected void withdraw(String accnr, long deposit) {

	}

	@Override
	public int getAmountSelectionColumnNum() {
		return 0;
	}

	@Override
	protected void addInterest() {

	}

	@Override
	public void update() {

	}
}
