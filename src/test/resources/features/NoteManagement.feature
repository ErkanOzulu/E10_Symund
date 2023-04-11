@SYMU10-515 @wip

Feature: Note  Module Functionality

  As a user, I want to be able to manage my notes so that I can keep track of my thoughts and ideas.
@SYMU10-554
Scenario: Create a new note

    Given I am on the notes page
    When I click on the "Create Note" button
    And I fill in the note title and content
    And I click on the "Save" button
    Then I should see the new note on the notes page
@SYMU10-555
Scenario: Add note to favorites
    Given I have a note
    When I click on the "Add to Favorites" button for that note
    Then the note should be added to my favorites list
@SYMU10-556
  Scenario: View note details
    Given I have a note
    When I click on the note title
    Then I should see the note details, including the number of letters and words
    And I should see the option to add a new category
@SYMU10-557
Scenario: Create a new category
  Given I am on the note details page
  When i click  categories
  And write a new category name
  Then the new category created

@SYMU10-558
  Scenario: Delete a note
    Given I have a note
    When I clicked on the Delete button for that note
    Then the note should be deleted from the notes page
