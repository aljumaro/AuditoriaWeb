@ATM
Feature: Cash Withdrawal
  Scenario: Successful withdrawal from an account in credit
    Given I have deposited $100.01 in my account
    When I withdraw $20.01
    Then $20.01 should be dispensed