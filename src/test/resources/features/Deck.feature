Feature: Deck Module
  As a user, I should be able to manage my works by creating a
  new board/list/card and modifying them under Deck Module.

  @SYMU10-546
  Scenario Outline: User can create a new board
    Given user is logged in and on the dashboard page
    And user navigates to "deck"
    When User can see the three-line button and click it
    And User see the opened sidebar
    And User see the add-board button and click it
    And User sees the popup box and enters the "<board name>"
    And User click the submit button
    Then User can see the created "<board name>" on the side bar

    Examples:
      | board name  |
      | Galatasaray |
      | New board   |
      | New123      |
      | New 123     |
      | 123 new     |

  @boardCreated
  Scenario Outline: User can create a new list of card/task under any board
    When User is on the Deck page and created "Galatasaray" board
    And User see and click the + add list button
    And User write the "<list name>" in the windows that opens and presses enter
    Then User see the "<list name>" under board name

    Examples:
      | list name |
      | Main Team |
      | U23 Team  |
      | U19 Team  |



