package dev.bank;

import java.util.HashMap;
import java.util.Map;

public class Bank {

	public final int rountingNumber;
	private long lastTransactionId = 1;
	private final Map<String, BankCustomer> customers;

	public Bank(int rountingNumber) {
		this.rountingNumber = rountingNumber;
		customers = new HashMap<>();
	}

	public BankCustomer getCustomer(String id) {
		BankCustomer customer = customers.get(id);
		return customer;
	}

	public void addCustomer(String name, double checkingInitialDeposit,
							double savingsInitialDeposit) {

		BankCustomer customer = new BankCustomer(name,
				checkingInitialDeposit,
				savingsInitialDeposit);
		customers.put(customer.getCustomerId(), customer);
	}

	public boolean doTransaction(String id, BankAccount.AccountType accountType, double amount) {
		BankCustomer customer = customers.get(id);
		if (customer != null) {
			BankAccount account = customer.getAccount(accountType);
			if (account != null) {
				if ((account.getBalance() + amount) < 0) {
					System.out.println("Insufficient funds");
				} else {
					account.commitTransaction(rountingNumber, lastTransactionId++, id, amount);
					return true;
				}
			}
		} else {
			System.out.println("Invalid customer id");
		}
		return false;
	}
}
