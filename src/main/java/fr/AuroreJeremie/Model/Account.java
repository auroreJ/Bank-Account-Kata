package fr.AuroreJeremie.Model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 
 * @author ajeremie
 *
 */
public interface Account {

	/**
	 * make a deposit in a account
	 * 
	 * @param amount
	 *            for the deposit
	 */
	void makeDeposit(BigDecimal amount, LocalDateTime date);

}