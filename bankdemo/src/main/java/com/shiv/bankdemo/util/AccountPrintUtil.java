
package com.shiv.bankdemo.util;

import java.util.List;
import java.util.logging.Logger;
import com.shiv.bankdemo.model.BankAccount;
import com.shiv.bankdemo.model.BankTransaction;

/**
 * This is responsible for printing transaction data
 */
public class AccountPrintUtil {
	// Create a logger with the name of the current class
	private static Logger logger = Logger.getLogger(AccountPrintUtil.class.getName());

	public static void printFilteredData(List<BankAccount> filteredAccounts) {
		// Print the remaining events in the output
		for (BankAccount account : filteredAccounts) {
			logger.info(
					"===================================Bank Account====================================================");
			logger.info("User Idenfiter: " + account.getUserIdentifier());
			logger.info("Idenfiter: " + account.getIdentifier());
			logger.info("Account: " + account.getAccountType().name());
			logger.info(
					"===================================BankTransaction=================================================");
			for (BankTransaction transaction : account.getTransactions()) {
				logger.info("Date: " + transaction.getDate() + ", Description: " + transaction.getDescription()
						+ ", Type: " + transaction.getType() + ", Recipient: " + transaction.getRecipient()
						+ ", Amount: " + transaction.getAmount());
			}

		}
		logger.info("==========================================================================");
	}
}
