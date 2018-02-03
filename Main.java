package main;

import java.util.ArrayList;
import java.util.List;

import abstraction.InsufficientBalanceException;
import banking.AccountGenerator;
import banking.Banking;
import implpementation.BankingImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> accNames = new ArrayList<>();
		int accountNo = AccountGenerator.accountGenerator();
		accNames.add("Jacob Smith");
		// creation of object for checking account
		Banking obj = new Banking(accountNo, accNames, "checking", 0);
		System.out.println("new account has been generated for " + obj.getNames().get(0) + "with Acc No:" + accountNo);
		BankingImpl obj2 = new BankingImpl();

		System.out.println(obj2.Deposit(obj, 1000));

		// obj2.interest(obj, 10, )
		try {

			System.out.println(obj2.withdrawl(obj, 250));
		} catch (InsufficientBalanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(obj2.currentInterest(obj, 10));

		try {

			System.out.println(obj2.withdrawl(obj, 800));
		} catch (InsufficientBalanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("checking balance is:" + obj.getAccountbalance());

		obj2.currentInterest(obj, 20);
		System.out.println("checking balance is:" + obj.getAccountbalance());

		int accountNo2 = AccountGenerator.accountGenerator();

		List<String> accNames2 = new ArrayList<>();
		accNames2.add("Angela Demello");
		// creation of object for savings account
		Banking obj3 = new Banking(accountNo2, accNames2, "Savings", 900);
		System.out.println("new account has been generated for " + obj3.getNames().get(0) + "with Acc No: " + accountNo2);

		System.out.println(obj2.savingsInterest(obj3, 10));
		System.out.println(obj2.Deposit(obj3, 100));
		System.out.println(obj2.savingsInterest(obj3, 10));

		// try and catch statements
		try {
			System.out.println(obj2.withdrawl(obj3, 1000));
		} catch (InsufficientBalanceException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println("Current Balance is " + obj3.getAccountbalance());
		}

	}

}
