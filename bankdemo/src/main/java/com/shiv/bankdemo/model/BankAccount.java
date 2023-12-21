
package com.shiv.bankdemo.model;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * BankAccount is a model that represents an individual bank account. It is
 * designed to store a list of BankTransaction objects, capturing the
 * transaction history associated with that account. Each BankTransaction object
 * within the list represents a specific financial transaction related to the
 * account.
 */
public class BankAccount {
	@NotBlank
	private final String identifier;

	@NotBlank
	private final String userIdentifier;

	@NotBlank
	private final AccountType accountType;

	@Valid
	@NotEmpty
	private List<BankTransaction> transactions;

	/**
	 * @param identifier
	 * @param userIdentifier
	 * @param transactions
	 */
	public BankAccount(@NotBlank AccountType accountType, @NotBlank String identifier, @NotBlank String userIdentifier,
			@Valid @NotEmpty List<BankTransaction> transactions) {
		super();
		this.identifier = identifier;
		this.userIdentifier = userIdentifier;
		this.transactions = transactions;
		this.accountType = accountType;
	}

	public List<BankTransaction> getTransactions() {
		return transactions;
	}

	public String getIdentifier() {
		return identifier;
	}

	public String getUserIdentifier() {
		return userIdentifier;
	}

	public AccountType getAccountType() {
		return accountType;
	}
}