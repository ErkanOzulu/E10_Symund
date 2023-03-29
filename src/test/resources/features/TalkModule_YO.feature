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
    And User verify group name "Group18"

