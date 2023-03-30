Feature:Dashboard page

  Background: user is expected to be on the dashboard page
    Given user is logged in and on the dashboard page
@wip
  Scenario Outline:Verify that user can navigate to modules on dashboard page
    When user navigates to "<modules>"
    Then verify that user lands on "<modules>" page

    Examples:
      | modules  |
      | dashboard|
      | files    |
      | photos   |
      | activity |
      | spreed   |
      | mail     |
      | contacts |
      | circles  |
      | calendar |
      | notes    |
      | deck     |
      | tasks    |
