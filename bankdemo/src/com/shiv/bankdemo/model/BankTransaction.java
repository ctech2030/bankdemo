
package com.shiv.bankdemo.model;

import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * BankTransaction is a model that represents an individual transaction within a
 * bank. It has several attributes that capture essential information about the
 * transaction, such as the transaction date, description, type (e.g., payment
 * or transfer), recipient, and the transaction amount.
 */
public class BankTransaction {
	@NotNull
	private final LocalDate date;
	@NotBlank
	private final String description;
	@NotBlank
	private final TransactionType type;
	private String recipient;
	@NotNull
	private final double amount;

	public BankTransaction(LocalDate date, String description, TransactionType type, String recipient, double amount) {
		this.date = date;
		this.description = description;
		this.type = type;
		this.recipient = recipient;
		this.amount = amount;
	}

	public BankTransaction(LocalDate date, String description, TransactionType type, double amount) {
		this.date = date;
		this.description = description;
		this.type = type;
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getDescription() {
		return description;
	}

	public TransactionType getType() {
		return type;
	}

	public String getRecipient() {
		return recipient == null ? "" : recipient;
	}

	public double getAmount() {
		return amount;
	}
}