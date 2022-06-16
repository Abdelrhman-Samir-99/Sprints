@smoke
Feature: F01_Register | users could register with new accounts
  Scenario: guest user could register with valid data successfully
    Given user go to register page
    When user select gender type
    And user enter first and last name
    And user enter date of birth
    And user enter email
    And user enter company name
    And user enter password and validate it
    Then user click on register button and user see success message