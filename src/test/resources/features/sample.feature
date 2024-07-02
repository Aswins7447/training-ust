@tag
Feature: AdvantageDemo login function

  Background: the user is in the AdvantageDemo home page.
  Given: user is in home page

  @valid
  Scenario: Login with valid credentials
    When valid <username> is entered
    And valid <password> is entered
    And sign-in button is clicked
    Then the user is logged in
    
    Examples: 
      | username      | password          | status              |
      | qwerty123     | Qwerty@123        | Login successful    |

  @invalid
  Scenario: Login with invalid credentials
    When invalid <username> is entered
    And invalid <password> is entered
    And sign-in button is clicked
    Then appropriate error message is thrown
    
    Examples: 
      | username      | password          | status              |
      | invalid_user1 | invalid_password1 | Invalid credentials |
      | valid_user2   | invalid_password2 | Invalid credentials |
      | invalid_user2 | valid_password2   | Invalid credentials |
