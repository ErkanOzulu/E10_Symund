Feature: Settings should be test step by step

  Background: User click to user profil part

  Scenario: User should see part of settings
    When user click to settings part
    Then user verify to open new page
    Then verify user should see "full name"
    Then verify user should see "email"
    Then verify user should see "phone number"

  Scenario: User should see "profil name" in "full name"
    When user click to settings part
    And user click to profil icon
    Then user verify full name value should be in profil icon

  Scenario: user should see private when click to phone number lock
    When user click to settings part
    And user click to phone number lock
    Then verify user should see private section

  Scenario: User shoul see day current time in page
    When user click to settings part
    Then verify user should see current time

