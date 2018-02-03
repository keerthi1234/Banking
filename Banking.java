
package banking;

import java.util.List;
import abstraction.InsufficientBalanceException;

public class Banking {

	private int Accountnumber;
	private List<String> names;
	private String Accounttype;
	private double Accountbalance;

	// setfunction for account number
	public void setAccountnumber(int accountnumber) {
		Accountnumber = accountnumber;
	}

	// setfunction for names
	public void setNames(List<String> names) {
		this.names = names;
	}

	// setfunction for accounttype
	public void setAccounttype(String accounttype) {
		Accounttype = accounttype;
	}

	// setfunction for account balance
	public void setAccountbalance(double accountbalance) {
		Accountbalance = accountbalance;
	}

	// constructors
	public Banking(int accountnumber, List<String> names, String accounttype, double accountbalance) {
		super();
		Accountnumber = accountnumber;
		this.names = names;
		Accounttype = accounttype;
		Accountbalance = accountbalance;
	}

	// get functions
	public int getAccountnumber() {
		return Accountnumber;
	}

	public List getNames() {
		return names;
	}

	public String getAccounttype() {
		return Accounttype;
	}

	public double getAccountbalance() {
		return Accountbalance;
	}

	public String Deposit(float amount) {
		Accountbalance = Accountbalance + amount;
		return "balance after deposit=" + Accountbalance;

	}

	// withdrawl function to withdraw amount from account
	// exceptionss
	public String withdrawl(float amount) throws InsufficientBalanceException {

		if (amount <= Accountbalance) {
			Accountbalance = Accountbalance - amount;
			return "amount withdrawn succesfully with balance=" + Accountbalance;
		}

		throw new InsufficientBalanceException("balance is low and the available balance is: " + Accountbalance);

	}

	// Add function to add account holder
	public String add(String name) {
		names.add(name);
		return "Account holder added successfully!!!";

	}

}
