package fr.AuroreJeremie;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import cucumber.api.java8.En;
import fr.AuroreJeremie.Model.CheckingAccount;
import fr.AuroreJeremie.Service.ConsolePrinter;

public class AccountStepDefinition implements En {

	private CheckingAccount account;

	public AccountStepDefinition() {

		Given("^a account$", () -> {
			account = new CheckingAccount();
		});

		When("^I make a deposit of (\\d+) euro in my account$", (BigDecimal amount) -> {
			account.makeDeposit(amount, LocalDateTime.now());
		});

		When("^I make a withdrawal of (\\d+) euro in my account$", (BigDecimal amount) -> {
			account.makeWithdrawal(amount, LocalDateTime.of(2017, 06, 25, 14, 30));
		});

		When("^I check my operations$", () -> {
			account.print(new ConsolePrinter());
		});

		Then("^My balance should be (-?\\d+)$",(BigDecimal expectedBalance) -> {
			assertThat(account.getTransactionsHistory().get(0)
							.getBalance()).isEqualByComparingTo(expectedBalance);
		});

		Then("^the history of my operations shows (\\d+) transactions$", (Integer count) -> {
			assertThat(account.getTransactionsHistory().size()).isEqualTo(count);
		});
	}
}
