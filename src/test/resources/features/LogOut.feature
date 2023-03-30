
Feature:Log out functionality

  As a user I should be able to log out.

  Background:user is expected to be on the dashboard page
    Given user is logged in and on the dashboard page

  Scenario:User can log out and ends up in login page
    When click the account name dropdown in the top right corner
    And check the Log out button in the dropdown
    And click Log out button
    Then Verify that user should be able to logout and ends up on the login page

  Scenario: User shouldn't be able to go to  home page again
  by clicking step back button after successfully logged out
    Given user is logged out
    When Click the step back button in the top left corner
    Then Verify that user shouldn't be able to go to the home page  again

