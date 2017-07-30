Feature: Account

Background:
  Given a account

Scenario: saving money in a account
  When I make a deposit of 50 euro in my account
  Then My balance should be 50

Scenario: Retrieving my savings
  When I make a withdrawal of 50 euro in my account
  Then My balance should be -50

Scenario: Checking my operations
  Given I make a deposit of 65 euro in my account
    And I make a withdrawal of 90 euro in my account
  When I check my operations
  Then the history of my operations shows 2 transactions