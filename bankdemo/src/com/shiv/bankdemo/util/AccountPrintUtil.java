
package com.shiv.bankdemo.util;

import java.util.List;

import com.shiv.bankdemo.model.BankAccount;
import com.shiv.bankdemo.model.BankTransaction;

/**
 * This is responsible for printing transaction data
 */
public class AccountPrintUtil {
	public static void printFilteredData(List<BankAccount> filteredAccounts) {
		// Print the remaining events in the output
		for (BankAccount account : filteredAccounts) {
			System.out.println(
					"===================================Bank Account====================================================");
			System.out.println("User Idenfiter: " + account.getUserIdentifier());
			System.out.println("Idenfiter: " + account.getIdentifier());
			System.out.println("Account: " + account.getAccountType().name());
			System.out.println(
					"===================================BankTransaction=================================================");
			for (BankTransaction transaction : account.getTransactions()) {
				System.out.println("Date: " + transaction.getDate() + ", Description: " + transaction.getDescription()
						+ ", Type: " + transaction.getType() + ", Recipient: " + transaction.getRecipient()
						+ ", Amount: " + transaction.getAmount());
			}

		}
		System.out.println("==========================================================================");
	}
}
