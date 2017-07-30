package fr.AuroreJeremie;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import cucumber.api.java8.En;
import fr.AuroreJeremie.Model.CheckingAccount;

public class AccountStepDefinition implements En {

	private CheckingAccount account;

	public AccountStepDefinition() {

		Given("^a account$", () -> {
			account = new CheckingAccount();
		});

		When("^I make a deposit of (\\d+) euro in my account$", (BigDecimal amount) -> {
			account.makeDeposit(amount, LocalDateTime.now());
		});

		Then("My balance should be (\\d+)", (BigDecimal expectedBalance) -> {
			assertThat(account.getTransactionsHistory().get(0).getBalance())
					.isEqualByComparingTo(expectedBalance);
		});
	}
}
