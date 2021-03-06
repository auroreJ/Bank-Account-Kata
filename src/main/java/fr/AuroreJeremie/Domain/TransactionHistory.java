package fr.AuroreJeremie.Domain;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

/**
 * Representation of a Transaction and a Balance
 * @author AURORE
 *
 */
public final class TransactionHistory {

	private static final String PATTERN = "yyyy/MM/dd";
	private final Transaction transaction;
	private final BigDecimal balance;

	public TransactionHistory(Transaction transaction, BigDecimal balance) {
		this.transaction = transaction;
		this.balance = balance;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "TransactionHistory [operation=" + transaction.getType()
				+ ", date=" + transaction.getDate().format(DateTimeFormatter.ofPattern(PATTERN)) + ", amount="
				+ transaction.getAmount() + ", balance=" + balance + "]";
	}

}
