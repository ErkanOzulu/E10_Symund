@SYMU10-562
Feature:Contacts page

  Background:
    Given user is logged in and on the dashboard page
    When user navigates to "contacts"

  @SYMU10-545
  Scenario:User should be able to create a new contact
    When User click on new contact
    And User enter name of the contact and last name in  input Company box
      | Alp   | Cevik |
    Then Verify that appears in the <All contacts> list with matching initials


  @SYMU10-567
  Scenario:User can see all the contacts as a list and total number
    When User click on new contact
    And User enter name of the contact and last name in  input Company box
      | Altar | Avcı  |
      | Erkan | Ozulu |
    And User click on All contact button
    Then Verify that  contacts as a list inside the middle column
    Then Verify that  total number of the contacts near the “All Contacts” tab


