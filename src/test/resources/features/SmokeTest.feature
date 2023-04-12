@smoke
Feature:
Background:
 Given user is logged in and on the dashboard page

  @SYMU10-547
  Scenario:Verify  user can create a new group conversation by adding other users
    When User click talk module
    And user click add button
    And user enter "Group23" as Conversation name on displayed field
    And User click add participants button
    And User add participants that have name as below
      | Ayberk |
      | Betul  |
      | Zack   |
    And User click create Conversation button

    Then User verify group name "Group23"


  @SYMU10-577
  Scenario: User can see the deleted files board
    Given user navigates to "files"
    When user clicks Deleted files tab
    Then verify that user can see deleted files board
  @SYMU10-579
  Scenario: User can order the all deleted files by newest to oldest or visa versa
    Given user navigates to "files"
    When user clicks Deleted files tab
    And there are at least two different files that were deleted in the different time periods
    When user clicks order by "Deleted"
    Then Verify that all deleted files can be ordered by newest to oldest or visa versa
  @SYMU10-566
  Scenario: Add any task to the list of completed Tasks
    When user navigate to "Tasks" page
    And added new task list with "New Task List" name
    And click to new task input box
    And write a new task name "New Task" to new task input box and click enter
    And click to completed task checkbox on the task module
    Then user should see the completed date message on the task module
  @SYMU10-582
  Scenario Outline: User can create a new list of card/task under any board
    When User is on the Deck page and then created "Galatasaray" board
    And User see and click the + add list button
    And User write the "<list name>" in the windows that opens and presses enter
    Then User see the "<list name>" under board name

    Examples:
      | list name |
      | Main Team |
      | U23 Team  |
      | U21 Team  |
  @SYMU10-601
  Scenario:User can delete any selected contact
    When user navigates to "contacts"
    And User select one of the contacts
    And User click on three dot button
    And User click on Delete button
    Then Verify that  the contact deleted