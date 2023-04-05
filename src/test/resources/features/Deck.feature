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

  @SYMU10-582
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

  @SYMU10-587
  Scenario Outline: User can add a new card/task on any list on the current board
    When User is on the Deck page and created "Galatasaray" board
    And User click the add list button, created the "Main Team" list and click add card button
    And User see the input card name box under "Main Team" and write the "<card name>" and presses enter from keyboard
    Then User see the "<card name>" under "Main Team" list

    Examples:
      | card name        |
      | Kerem Akturkoglu |
      | Fernando Muslera |

  @SYMU10-588
  Scenario: User can assign any card/task to himself/herself by using the three dots on the related card
    When User is on the Deck page and created "Galatasaray" board
    When User see and click on three dots button under any task
    And User see assign to me button and click on it
    Then User see the assigned to me image under card

    Scenario: User can move any card on the current board to any other list of other board
      When User is on the Deck page and created "Galatasaray" board
      And User see the "Main Team" list name and "Kerem Akturkoglu" card under the list
      And User move the "Kerem Akturkoglu" card under "U19 Team" list
      Then User see the "U19 Team" list name and "Kerem Akturkoglu" card under the list





