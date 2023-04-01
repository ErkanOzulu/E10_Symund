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

