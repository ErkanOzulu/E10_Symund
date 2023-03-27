
Feature: Login Functionality
  As a user, I should be able to login.



  Scenario: Login with valid credentials by clicking login button
    When Go to login page
    And Enter valid username in username field
    And Enter valid password in password field
    And Click on the login button
    Then Verify that user can login


  Scenario: Login with valid credentials  by hitting  "Enter" key from the keyboard
    When Go to login page
    And Enter valid username in username field and password in password field
      | username | Employee130 |
      | password | Employee123 |
    And hit enter key word
    Then Verify that user can login


  Scenario Outline: user can not login with invalid credentials
    When Go to login page
    And Enter referred credentials "<username>" "<password>"
    And Click on the login button
    Then user should not be login and  see the message "Wrong username or password."

    Examples:

      | username    | password    |
      | Employee130 | asde123     |
      | saasEe13    | asde123     |
      | saasEe130   | Employee123 |
      | employee130 | Employee123 |
      | Employee123 | employee123 |


  Scenario Outline: user can not login with blank credentials
    When Go to login page
    And Enter referred credentials "<user>" "<password>"
    And Click on the login button
    Then "<user>" should not be login and  see the pop-up message "Please fill out this field."

    Examples:
      | user        | password    |
      | Employee130 |             |
      | employee130 |             |
      |             |             |
      |             | Employee123 |
      |             | employee123 |


  Scenario: user can see password in a form of dots by default after entering password
    When Go to login page
    And Enter username "Employee130" in username field
    And Enter password "Employee123" in password field
    Then User can see the password in a form of dots by default


  Scenario:Verify that user can see the password explicitly if needed
    When Go to login page
    And Enter password "Employee123" in password field
    And Click eye sign in password field
    Then  user should be able to see the password explicitly


  Scenario: Verify user can see the "Reset Password" button on the next page after clicking on forget password link
    When Go to login page
    And Check Forget password? link on the login page
    And Click  Forget password? link
    Then User can see the Reset password button on the next page


  Scenario:Verify that user can see valid placeholders on Username and Password fields
    When Go to login page
    And Check username and password field
    Then user can see expected placeholders in related field
      | in_username | Username or email |
      | in_password | Password          |




  #Declarative Example:

#  Scenario: Verify login
#
#    Given user navigate to the Website
#
#    When user enters credentials
#
#    Then the user clicks on the sign-in button
#
#    Then validate the title after login

