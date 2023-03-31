Feature: Settings should be test step by step

  Background:user is expected to be on the dashboard page
    Given user is logged in and on the dashboard page
    When user click to profil icon


  Scenario Template: User should see part of settings
    When user click to settings part
    Then user verify to open new page
    Then verify user should see "<looked>"

    Examples:
      | looked |
      | name   |
      | email  |
      | phone  |


