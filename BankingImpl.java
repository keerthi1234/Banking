package implpementation;

import java.util.ArrayList;
import java.util.List;

import abstraction.BankingAbstract;
import abstraction.InsufficientBalanceException;
import banking.Banking;

public class BankingImpl extends BankingAbstract {

	@Override
	public int getAccnumber(Banking acc) {
		return acc.getAccountnumber();
	}

	@Override
	public List<String> getNames(Banking obj) {
		List<String> names = new ArrayList<>();
		names = obj.getNames();
		return names;
	}

	@Override
	public double getAccBalance(Banking acc) {
		// TODO Auto-generated method stub
		return acc.getAccountbalance();
	}

	@Override
	public String getAccType(Banking acc) {
		// TODO Auto-generated method stub
		return acc.getAccounttype();

	}

	@Override
	public String Deposit(Banking acc, float amount) {
		// TODO Auto-generated method stub
		return acc.Deposit(amount);
	}

	@Override
	public String withdrawl(Banking acc, float amount) throws InsufficientBalanceException {
		// TODO Auto-generated method stub

		if (acc.getAccounttype().equals("Savings")) {
			if (acc.getAccountbalance() - amount >= 100) {
				acc.setAccountbalance(acc.getAccountbalance() - amount);
				return ("The account balance after the withdrawl of the amount is " + acc.getAccountbalance());
			} else {
				throw new InsufficientBalanceException(
						"Withdrawl Failed! Maintain a minimium balance of 100 and try withdrawing a lower amount.");
			}
		}

		return acc.withdrawl(amount);
	}

	@Override
	public String addAccHolder(Banking obj, String name) {
		obj.add(name);
		return "Account holder " + name + "has been added successfully to the acount";
	}

	@Override
	public String interest(Banking obj, float days, float rate) {
		// TODO Auto-generated method stub
		double balance = obj.getAccountbalance();
		float interest = (float) ((balance * days * rate) / 100);
		balance = balance + interest;
		return "account balnace after adding the interest is " + balance;
	}

	// current interest calculation
	public String currentInterest(Banking obj, float days) {
		// TODO Auto-generated method stub
		double balance = obj.getAccountbalance();
		float interest = (float) ((balance * days * 0.01) / 100);
		balance = balance + interest;
		obj.setAccountbalance(balance);
		return "account balnace after adding the interest is " + balance;
	}

	// savings interest calculation
	public String savingsInterest(Banking obj, float days) {
		float interest = 0;
		double balance = obj.getAccountbalance();
		if (obj.getAccountbalance() < 1000) {
			interest = (float) ((balance * days * 0.01) / 100);
			obj.setAccountbalance(balance + interest);
		} else if (obj.getAccountbalance() >= 1000 && obj.getAccountbalance() < 10000) {
			interest = (float) ((balance * days * 0.05) / 100);
			obj.setAccountbalance(balance + interest);
		} else if (obj.getAccountbalance() >= 10000) {
			interest = (float) ((balance * days * 0.1) / 100);
			obj.setAccountbalance(balance + interest);
		}
		return "The account balance is" + balance;

	}

}
