Feature: Settings should be test step by step

  Background: User click to user profil part

  Scenario: User should see part of settings
    When user click to settings part
    Then user verify to open new page
    Then verify user should see "full name"
    Then verify user should see "email"
    Then verify user should see "phone number"


