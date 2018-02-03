package banking;

//class for account generation
public class AccountGenerator {

	private static int accountNo = 124564;

	// account generation function
	public static int accountGenerator() {
		accountNo = accountNo + 1;
		return (accountNo);

	}
}
