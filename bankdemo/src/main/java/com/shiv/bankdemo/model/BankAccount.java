
package com.shiv.bankdemo.model;

import java.util.List;
import java.util.UUID;

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
	private final UUID  identifier;

	@NotBlank
	private final UUID  userIdentifier;

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
	public BankAccount(@NotBlank AccountType accountType, @NotBlank UUID  identifier, @NotBlank UUID  userIdentifier,
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

	public UUID  getIdentifier() {
		return identifier;
	}

	public UUID  getUserIdentifier() {
		return userIdentifier;
	}

	public AccountType getAccountType() {
		return accountType;
	}
}