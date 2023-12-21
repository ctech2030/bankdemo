# Bank Data Processor

The `BankDataProcessor` is a utility class designed to process bank-related data, specifically handling transactions and accounts.

## Assumptions

1. **BankTransaction Class:**
    - Represents an individual transaction within a bank account.
    - Assumes the existence of a `TransactionType` enum with types like `PAYMENT` and `TRANSFER`.
    - Supports various transaction types, including payments and transfers.
    - The `date` attribute represents the date of the transaction.
    - The `description` attribute contains a brief description of the transaction.
    - The `type` attribute specifies the type of transaction (e.g., payment, transfer).
    - The `amount` attribute represents the transaction amount.
    - For payment transactions, a `recipient` attribute stores the recipient's information.

2. **BankAccount Class:**
    - Represents a bank account that holds transactions.
    - Assumes the existence of the `BankTransaction` class.
    - The `accountNumber` attribute uniquely identifies the bank account.
    - The `transactions` attribute is a list containing all transactions associated with the account.

3. **BankDataProcessor Class:**
    - Provides a method `detectTimeInterval` to identify time intervals between subsequent transactions for a specific text.
    - Assumes the existence of the `BankAccount` and `BankTransaction` classes.
    - Utilizes a predefined enum `TimeInterval` with types `MONTHLY` and `BIWEEKLY`.
    - Assumes transactions are ordered by date.

## Usage

To use the `BankDataProcessor` class, follow these steps:

1. Create instances of `BankAccount` and populate them with `BankTransaction` instances.
2. Call the `detectTimeInterval` method with the list of `BankAccount` instances and the specific text you want to analyze.


// Example Usage:
List<BankAccount> accounts = // create and populate accounts

String searchText = "Video streaming";
BankDataProcessor.TimeInterval detectedInterval = BankDataProcessor.detectTimeInterval(accounts, searchText);
print "Detected Interval: " + detectedInterval
