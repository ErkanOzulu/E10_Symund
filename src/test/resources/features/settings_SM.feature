@SYMU10-574
Feature: Settings should be test step by step

  Background:user is expected to be on the settings dashboard page
    Given user is logged in and on the dashboard page
    When user click to profile icon
    When user click to settings part


  @SYMU10-569
  Scenario Outline: User should see part of settings
    Then user verify to open new page
    Then verify user should see "<looked>"

    Examples:
      | looked |
      | name   |
      | email  |
      | phone  |

  @SYMU10-570
  Scenario: User should see "profile name" in "full name"
    And user click to profile icon
    Then user verify full name value should be in profile icon

  @SYMU10-571
  Scenario: user should see private when click to phone number lock
    And user click to phone number lock
    Then verify user should see private section
    Then verify user click to private should see phone icon

  @SYMU10-572
  Scenario: User should see day current time in page
    Then verify user should see current time

