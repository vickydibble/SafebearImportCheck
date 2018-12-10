Feature: Login
  In order to access the website
  As a user
  I want to know if my login is successful

  Rules:
  *The user must be informed if the login information is incorrect
  *The user must be informed if the login is successful

  Glossary:
  *User: Someone who wants to create a Tools List using our application
  *Supporters: This is what the customer calls 'Admin' users

  @HighRisk
  @HighImpact
  Scenario Outline: Navigate and login to the application
    Given I navigate to the login page
    When I enter the login details for '<userType>'
    Then I can see the following message: '<validationMessage>'

    Examples:
      | userType    | validationMessage                 |
      | InvalidUser | Username or password is incorrect |
      | validUser   | Login successful                  |

