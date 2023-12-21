
package com.shiv.bankdemo.test;

import static com.shiv.bankdemo.util.AccountPrintUtil.printFilteredData;
import static com.shiv.bankdemo.util.BankAccountTestDataUtil.getAccount;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

import com.shiv.bankdemo.model.AccountType;
import com.shiv.bankdemo.model.BankAccount;
import com.shiv.bankdemo.processor.BankDataProcessor;
import com.shiv.bankdemo.processor.TimeInterval;

public class BankDataProcessorTest {
	// Create a logger with the name of the current class
	Logger logger = Logger.getLogger(BankDataProcessorTest.class.getName());

	private BankDataProcessor bankDataProcessor;

	private List<BankAccount> accounts;

	@Before
	public void setup() {
		bankDataProcessor = new BankDataProcessor();
		accounts = new ArrayList<>();
		accounts.add(getAccount(AccountType.BANK_ACCOUNT));
		accounts.add(getAccount(AccountType.CC_ACCOUNT));
	}

	@Test
	public void testFilterPositiveTransactions() {

		// Filter positive transactions
		List<BankAccount> filteredAccounts = bankDataProcessor.filterPositiveTransactions(accounts);
		printFilteredData(filteredAccounts);

		// Assert the expected results total size
		assertEquals(2, filteredAccounts.size());

		BankAccount bankAccount = filteredAccounts.get(0);
		assertEquals(8, bankAccount.getTransactions().size());
		assertEquals("Gym", bankAccount.getTransactions().get(0).getDescription());

		// The current value at index 5 is 'Salary'; after removal, it should be 'Video
		// streaming'
		assertEquals("Video streaming", bankAccount.getTransactions().get(5).getDescription());

		BankAccount ccAccount = filteredAccounts.get(1);
		assertEquals(3, ccAccount.getTransactions().size());
		assertEquals("Bar", ccAccount.getTransactions().get(1).getDescription());

		logger.info("==========================================================================");
		// Detect the time interval ex detect that “Gym” occurs biweekly
		logger.info("Interval detect that “Gym” occurs : " + bankDataProcessor.detectTimeInterval(accounts, "Gym"));
	}

	@Test
	public void testCalculateBankAccountBalance() {
		// Calculate the balance
		double calculatedBalance = bankDataProcessor.calculateBankAccountBalance(accounts.get(0));
		assertEquals(8853.0, calculatedBalance, 0.001);

		double calculatedBalanceForCC = bankDataProcessor.calculateBankAccountBalance(accounts.get(1));
		assertEquals(211.0, calculatedBalanceForCC, 0.001);
	}

	@Test
	public void testDetectBiweeklyInterval() {
		// Call the method to be tested
		TimeInterval detectedBiweeklyInterval = bankDataProcessor.detectTimeInterval(accounts, "Gym");

		// Assert the expected result (should be biweekly)
		assertEquals(TimeInterval.BIWEEKLY, detectedBiweeklyInterval);

	}

	@Test
	public void testDetectMonthlyInterval() {

		// Call the method to be tested
		TimeInterval detectedMonthlyInterval = bankDataProcessor.detectTimeInterval(accounts, "Video streaming");

		// Assert the expected result (should be monthly)
		assertEquals(TimeInterval.MONTHLY, detectedMonthlyInterval);

	}

}
