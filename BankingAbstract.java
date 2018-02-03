package abstraction;

import java.util.List;

import banking.Banking;

public abstract class BankingAbstract {
	// abstract methods
	public abstract int getAccnumber(Banking obj);

	public abstract List<String> getNames(Banking obj);

	public abstract double getAccBalance(Banking obj);

	public abstract String addAccHolder(Banking obj, String names);

	public abstract String Deposit(Banking obj, float amount);

	public abstract String withdrawl(Banking obj, float amount) throws InsufficientBalanceException;

	public abstract String getAccType(Banking obj);

	public abstract String interest(Banking obj, float days, float rate);

}
