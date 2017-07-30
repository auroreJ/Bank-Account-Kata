Feature: Account

Background:
  Given a account
  
Scenario: saving money in a account
  When I make a deposit of 50 euro in my account
  Then My balance should be 50

Scenario: Retrieving my savings
  When I make a withdrawal of 50 euro in my account
  Then My balance should be -50