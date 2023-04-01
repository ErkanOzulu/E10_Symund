Feature:Contacts page

  Background: user is expected to be on the dashboard page
    Given user is logged in and on the dashboard page
    When user navigates to "contacts"

  @SYMU10-545
  Scenario:User should be able to create a new contact
    When User click on new contact
    And User enter name of the contact in  input Company "Cydeo" box
    And User enter last name  in  input Title "Tech" box
    Then Verify that appears in the <All contacts> list with matching initials


    