Feature: Talk Module Functionality

  Background:
    When user is logged in and on the dashboard page
    And User click talk module

  Scenario:Verify  user can create a new group conversation by adding other users

    When user click add button
    And user enter "Group18" as Conversation name on displayed field
    And User click add participants button
    And User add participants that have name as below
      | Ayberk |
      | Betul  |
      | Zack   |
    And User click create Conversation button
    Then User verify group name "Group18"

  Scenario: Verify user can  see the added participants of the conversation on the right-hand menu under Participants
    When user click add button
    And user enter "Group18" as Conversation name on displayed field
    And User click add participants button
    And User add participants that have name as below
      | Ayberk |
      | Betul  |
      | Zack   |
    And User click create Conversation button
    Then Verify user should  see the added participants  on the right-hand menu

  Scenario: Verify user can remove any participant from the conversation

      When user click add button
      And user enter "Group18" as Conversation name on displayed field
      And User click add participants button
      And User add participants that have name as below
        | Ayberk |
        | Betul  |
        | Zack   |
      And User click create Conversation button
      And user click three point modul near the paricipant "Ayberk"
      And user click trash button from opened moudle
      Then user should verify that "Ayberk" name doesn't displey anymore
