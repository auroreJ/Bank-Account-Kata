package fr.AuroreJeremie.Domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Representation of a transaction
 * 
 * @author ajeremie
 *
 */
public class Transaction {

	private TransactionType type;
	private BigDecimal amount;
	private LocalDateTime date;

	public Transaction() {
	}

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
