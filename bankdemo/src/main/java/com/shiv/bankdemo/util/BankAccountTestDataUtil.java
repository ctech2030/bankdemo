
package com.shiv.bankdemo.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.shiv.bankdemo.model.AccountType;
import com.shiv.bankdemo.model.BankAccount;
import com.shiv.bankdemo.model.BankTransaction;
import com.shiv.bankdemo.model.TransactionType;

/**
 * This class is created to provide bank transaction test data
 */
public class BankAccountTestDataUtil {

	/**
	 * Test data for account transaction
	 * 
	 * @return List<BankTransaction>
	 */
	private static List<BankTransaction> getBankAccountTransactionTestData() {
		List<BankTransaction> tnxList = new ArrayList<>();
		BankTransaction transaction1 = new BankTransaction(LocalDate.of(2023, 8, 1), "Gym", TransactionType.PAYMENT,
				"123 -456", -200.0);
		BankTransaction transaction2 = new BankTransaction(LocalDate.of(2023, 7, 23), "Video streaming",
				TransactionType.TRANSFER, -99.0);
		BankTransaction transaction3 = new BankTransaction(LocalDate.of(2023, 7, 18), "Gym", TransactionType.PAYMENT,
				"123 - 453", -200.0);

		BankTransaction transaction4 = new BankTransaction(LocalDate.of(2023, 7, 4), "Gym", TransactionType.PAYMENT,
				"123 - 453", -200.0);

		BankTransaction transaction5 = new BankTransaction(LocalDate.of(2023, 6, 28), "Gym", TransactionType.PAYMENT,
				"123 - 453", -50.0);

		BankTransaction transaction6 = new BankTransaction(LocalDate.of(2023, 6, 25), "Salary",
				TransactionType.TRANSFER, 10000.0);
		BankTransaction transaction7 = new BankTransaction(LocalDate.of(2023, 6, 22), "Video streaming",
				TransactionType.TRANSFER, -99.0);
		BankTransaction transaction8 = new BankTransaction(LocalDate.of(2023, 6, 20), "Gym", TransactionType.PAYMENT,
				"123 - 453", -200.0);

		BankTransaction transaction9 = new BankTransaction(LocalDate.of(2023, 5, 23), "Video streaming",
				TransactionType.TRANSFER, -99.0);

		tnxList.add(transaction1);
		tnxList.add(transaction2);
		tnxList.add(transaction3);
		tnxList.add(transaction4);
		tnxList.add(transaction5);
		tnxList.add(transaction6);
		tnxList.add(transaction7);
		tnxList.add(transaction8);
		tnxList.add(transaction9);

		return tnxList;
	}

	/**
	 * Test data for credit card account transaction
	 * 
	 * @return List<BankTransaction>
	 */
	private static List<BankTransaction> getCcAccountTransactionTestData() {
		List<BankTransaction> creditTransactionList = new ArrayList<>();

		BankTransaction ccTnx = new BankTransaction(LocalDate.of(2023, 6, 20), "Pizza", TransactionType.PAYMENT, -70);
		BankTransaction ccTnx1 = new BankTransaction(LocalDate.of(2023, 6, 25), "Bar", TransactionType.PAYMENT, -120);
		BankTransaction ccTnx2 = new BankTransaction(LocalDate.of(2023, 7, 20), "Grocery store",
				TransactionType.PAYMENT, -99);
		BankTransaction ccTnx3 = new BankTransaction(LocalDate.of(2023, 7, 20), "CC Payment", TransactionType.PAYMENT,
				500);

		creditTransactionList.add(ccTnx);
		creditTransactionList.add(ccTnx1);
		creditTransactionList.add(ccTnx2);
		creditTransactionList.add(ccTnx3);
		return creditTransactionList;
	}

	/**
	 * I have utilized UUID.randomUUID() to generate the identifier. During real
	 * time, it might be necessary to incorporate logic for getting the actual
	 * value. Additionally, consider adding credit card masking logic if the
	 * mask cc number is not present
	 * 
	 * @param string
	 * @return
	 */
	public static BankAccount getAccount(AccountType type) {
		BankAccount bankAccount = null;
		switch (type) {
		case BANK_ACCOUNT:
			bankAccount = new BankAccount(type, UUID.randomUUID(), UUID.randomUUID(),
					getBankAccountTransactionTestData());
			break;
		case CC_ACCOUNT:
			bankAccount = new BankAccount(type, UUID.randomUUID(), UUID.randomUUID(),
					getCcAccountTransactionTestData());
			break;

		}
		return bankAccount;
	}
}
