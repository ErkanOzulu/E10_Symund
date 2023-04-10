@ionSYMU10-553
Feature: Talk Module Functionality

  Background:
    When user is logged in and on the dashboard page
    And User click talk module

  @SYMU10-547
  Scenario:Verify  user can create a new group conversation by adding other users
    And user click add button
    And user enter "Group23" as Conversation name on displayed field
    And User click add participants button
    And User add participants that have name as below
      | Ayberk |
      | Betul  |
      | Zack   |
    And User click create Conversation button

    Then User verify group name "Group23"
  @SYMU10-549
  Scenario: Verify user can  see the added participants of the conversation on the right-hand menu under Participants
When User click any group
    Then Verify user should  see the added participants  on the right-hand menu
@SYMU10-550
  Scenario: Verify user can remove any participant from the conversation
    When User click any group
    And user click settings modul near the paricipant "Ayberk"
    And user click trash button from opened moudle
    Then user should verify that "Ayberk" name doesn't displey anymore

@SYMU10-551
  Scenario: Verify that user can send messages by typing inside the inputbox at the bottom of the middle screen on Talk Module page
    When User click any group
    And User type "Hello" inside inputbox and enter
    Then Verify the message should be seen on the chat screen
@SYMU10-552
  Scenario: Verify that user can delete any group conversation previously created
    When User click settings Module near "Group23" conversation
    And User click trash button opening window
    And User click yes button displayed popup
    Then  verify "Group23"  has been deleted









