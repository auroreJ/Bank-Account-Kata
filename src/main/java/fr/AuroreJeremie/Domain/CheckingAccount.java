package fr.AuroreJeremie.Domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.AuroreJeremie.Service.Printer;

/**
 * Representation of a checking account
 * 
 * @author ajeremie
 *
 */
public class CheckingAccount implements Account {

	private List<TransactionHistory> transactionsHistory;

	public CheckingAccount() {
		transactionsHistory = new ArrayList<>();
	}

	@Override
	public void makeDeposit(BigDecimal amount, LocalDateTime date) {
		BigDecimal balance = getBalanceForTransaction(TransactionType.DEPOSIT, amount);
		transactionsHistory.add(new TransactionHistory(new Transaction(
				TransactionType.DEPOSIT, amount, date), balance));
	}

	@Override
	public void makeWithdrawal(BigDecimal amount, LocalDateTime date) {
		BigDecimal balance = getBalanceForTransaction(TransactionType.WITHDRAWAL, amount);
		transactionsHistory.add(new TransactionHistory(new Transaction(
				TransactionType.WITHDRAWAL, amount, date), balance));
	}

	private BigDecimal getBalanceForTransaction(TransactionType typeTransaction, BigDecimal amount) {
		return transactionsHistory.isEmpty() ? toBalance(typeTransaction,amount) 
					: (transactionsHistory.get(transactionsHistory.size() - 1).getBalance()
							.add(toBalance(typeTransaction, amount)));
	}

	private BigDecimal toBalance(TransactionType typeTransaction, BigDecimal amount) {
		if (typeTransaction.equals(TransactionType.WITHDRAWAL)) {
			return amount.negate();
		}
		return amount;
	}

	/**
	 * Print an account
	 * @param printer
	 */
	public void print(Printer printer) {
		transactionsHistory.forEach(th -> printer.printLn(th.toString()));
	}

	public List<TransactionHistory> getTransactionsHistory() {
		return transactionsHistory;
	}

	public void setTransactionsHistory(
			List<TransactionHistory> transactionsHistory) {
		this.transactionsHistory = transactionsHistory;
	}

}
