@SYMU10-544
Feature:Tasks Module Functionality

  As a user  I should be able to create a new task list or a single task and add any task to completed and important tasks list.

  Background:User is expected to be on the Tasks page

    Given user is logged in and on the dashboard page
    And user navigate to "Tasks" page

  @SYMU10-542
  Scenario: Create a new list of tasks

    When click to addList button
    And write a new list name "New Task List" to new list input box and click enter
    Then verify that user should see the new list link

  @SYMU10-564
  Scenario: Create a new task
    When added new task list with "New Task List" name
    And click to new task input box
    And write a new task name "New Task" to new task input box and click enter
    Then user should see the new task name link

  @SYMU10-566
  Scenario: Add any task to the list of completed Tasks
    When added new task list with "New Task List" name
    And click to new task input box
    And write a new task name "New Task" to new task input box and click enter
    And click to completed task checkbox on the task module
    Then user should see the completed date message on the task module

  @SYMU10-568
  Scenario: Add any task to the list of important Tasks
    When added new task list with "New Task List" name
    And click to new task input box
    And write a new task name "New Task" to new task input box and click enter
    And click to the star icon on the right side of task line
    Then user should see the new task in important tasks list

  @SYMU10-575
  Scenario: See the number of all uncompleted tasks next to the Current tab
    When added new task list with "New Task List" name
    And click to new task input box
    And write a new task name "New Task" to new task input box and click enter
    Then user should see the number of all uncompleted tasks next to the Current tab




