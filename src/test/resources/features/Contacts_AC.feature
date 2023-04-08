@SYMU10-562
Feature:Contacts page

  Background:
    Given user is logged in and on the dashboard page
    When user navigates to "contacts"

  @SYMU10-545
  Scenario:User should be able to create a new contact
    When User click on new contact
    And User enter name of the contact and last name in  input Company box
      | Alp | Cevik |
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

  @SYMU10-600
  Scenario:User can change the profile picture of any contact
    When User select one of the contacts
    And User click on the picture icon
    And User click on Choose from files button
    And User pick any avatar and click on choose button
    Then Verify that  the profile picture changes

  @SYMU10-601
  Scenario:User can delete any selected contact
    When User select one of the contacts
    And User click on three dot button
    And User click on Delete button
    Then Verify that  the contact deleted