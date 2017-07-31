package fr.AuroreJeremie.Domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Representation of a transaction
 * 
 * @author ajeremie
 *
 */
public final class Transaction {

	private final TransactionType type;
	private final BigDecimal amount;
	private final LocalDateTime date;

	public Transaction(TransactionType type, BigDecimal amount,
			LocalDateTime date) {
		this.type = type;
		this.amount = amount;
		this.date = date;
	}

	public TransactionType getType() {
		return type;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public LocalDateTime getDate() {
		return date;
	}
}
