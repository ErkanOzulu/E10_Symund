Feature: Settings should be test step by step

  Background:user is expected to be on the settings dashboard page
    Given user is logged in and on the dashboard page
    When user click to profil icon
    When user click to settings part


  Scenario Template: User should see part of settings
    Then user verify to open new page
    Then verify user should see "<looked>"


    Examples:
      | looked |
      | name   |
      | email  |
      | phone  |

  Scenario: User should see "profil name" in "full name"
    And user click to profil icon
    Then user verify full name value should be in profil icon

  Scenario: user should see private when click to phone number lock
    And user click to phone number lock
    Then verify user should see private section

  Scenario: User shoul see day current time in page
    Then verify user should see current time

