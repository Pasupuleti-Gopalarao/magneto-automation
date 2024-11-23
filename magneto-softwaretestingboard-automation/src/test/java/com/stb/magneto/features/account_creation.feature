@AccountCreation
Feature: Account Creation

  Scenario: Create a new account successfully
    Given I am on the signup page
    When I fill in valid account details
    And I click on the submit button
    Then my account should be created successfully

  Scenario: Handle missing mandatory fields
    Given I am on the signup page
    When I leave mandatory fields empty
    And I click on the submit button
    Then I should see error messages for required fields
