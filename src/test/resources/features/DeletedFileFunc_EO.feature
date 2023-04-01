Feature:Deleted Files Tab Functionality under Files Module
  User Story :

  As a user, I should be able to see all deleted files and delete/restore them permanently under the Deleted Files tab.

  4.User can delete any deleted file permenantly by using the three dots icon in the file’s line
  5.User can restore any deleted file and see it again under the All Files tab

  Background: user is expected to be on the dashboard page
    Given user is logged in and navigates to "files"


  Scenario: User can see the deleted files board
    When user clicks Deleted files tab
    Then verify that user can see deleted files board

  Scenario: User can see the most recent deleted file in the first line of the deleted file
    When user selects a file and click delete
    And navigates to Deleted files tab
    When user clicks order by "Deleted"
    Then verify that user should be able to see the most recent deleted file in the first line

  Scenario: User can order the all deleted files by newest to oldest or visa versa
    Given user clicks Deleted files tab
    And there are at least two different files that were deleted in the different time periods
    When user clicks order by "Deleted"
    Then Verify that all deleted files can be ordered by newest to oldest or visa versa

