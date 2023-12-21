
package com.shiv.bankdemo.processor;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.shiv.bankdemo.model.BankAccount;
import com.shiv.bankdemo.model.BankTransaction;

/**
 * The purpose of this class is to provide a method for handling and
 * manipulating banking data.
 */
public class BankDataProcessor {

	/**
	 * This is designed to process a list of BankAccount instances and filter out
	 * transactions with positive amounts
	 * 
	 * @param accounts
	 * @return List<BankAccount>
	 */
	public List<BankAccount> filterPositiveTransactions(List<BankAccount> accounts) {
		List<BankAccount> result = new ArrayList<>();
		for (BankAccount account : accounts) {
			List<BankTransaction> filteredTransactions = new ArrayList<>();

			for (BankTransaction transaction : account.getTransactions()) {
				if (transaction.getAmount() <= 0) {
					filteredTransactions.add(transaction);
				}
			}

			if (!filteredTransactions.isEmpty()) {
				result.add(new BankAccount(account.getAccountType(), account.getIdentifier(),
						account.getUserIdentifier(), filteredTransactions));
			}
		}

		return result;
	}

	/**
	 * The calculateBalance method in the is used to determine the total balance of
	 * the bank account based on its associated transactions
	 * 
	 * @param account
	 * @return balance
	 */
	public double calculateBankAccountBalance(BankAccount account) {
		double balance = 0;

		for (BankTransaction transaction : account.getTransactions()) {
			balance += transaction.getAmount();
		}

		return balance;
	}

	/**
	 * Method to detect time intervals between subsequent transactions for a
	 * specific text
	 * 
	 * @param accounts
	 * @param text
	 * @return TimeInterval
	 */
	public TimeInterval detectTimeInterval(List<BankAccount> accounts, String text) {
		TimeInterval interval = null;

		for (BankAccount account : accounts) {
			List<BankTransaction> transactions = account.getTransactions();
			List<BankTransaction> matchTransactions = transactions.stream()
					.filter(transaction -> transaction.getDescription().equals(text)).collect(Collectors.toList());
			if (matchTransactions != null && !matchTransactions.isEmpty()) {
				for (int i = 0; i < matchTransactions.size() - 1; i++) {
					BankTransaction currentTransaction = matchTransactions.get(i);
					BankTransaction nextTransaction = matchTransactions.get(i + 1);

					if (currentTransaction.getDescription().equals(text)
							&& nextTransaction.getDescription().equals(text)) {

						// Calculate the difference in days
						long daysDifference = ChronoUnit.DAYS.between(nextTransaction.getDate(),
								currentTransaction.getDate());

						// Assuming Weekly interval is 7 ,
						// Biweekly interval is 14 days and
						// Monthly interval is 30 days
						if (daysDifference == 7) {
							interval = TimeInterval.WEEKLY;
						} else if (daysDifference == 14) {
							interval = TimeInterval.BIWEEKLY;
						} else if (daysDifference == 30) {
							interval = TimeInterval.MONTHLY;
						}
					}
				}
			}
		}

		return interval;
	}

}
