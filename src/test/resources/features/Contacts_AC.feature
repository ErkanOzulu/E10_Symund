Feature:Contacts page

  Background: user is expected to be on the dashboard page
    Given user is logged in and on the dashboard page
    When user navigates to "contacts"

  @SYMU10-545
  Scenario:User should be able to create a new contact
    When User click on new contact
    And User put name of the contact in Company input box
    And User put last name of the contact in Title input box
    Then Verify that appears in the <All contacts> list with matching initials
      | All contacts |
      |              |
      |              |

    