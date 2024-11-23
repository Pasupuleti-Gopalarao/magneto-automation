@Login
Feature: Login Functionality

  Scenario: Login with valid credentials
    Given I am on the login page
    When I enter valid credentials
    And I click on the login button
    Then I should be redirected to the homepage

  Scenario: Login with invalid credentials
    Given I am on the login page
    When I enter invalid credentials
    And I click on the login button
    Then I should see an error message indicating invalid login
