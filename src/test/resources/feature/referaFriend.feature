#Author : Anjai K R
@Referafriendfunctionality
Feature: Testing Refer a Friend functionality

  @refer-friend
  Scenario: Referring a friend
    Given the user is on the home page
    When the user scrolls down and clicks on the refer a friend link
    And is redirected to the refer a friend page
    And enters their email address as "<email>"
    And clicks on the Next button
    And enters their friends email address as "<mailid>"
    And clicks on the Next button
    Then the "Thank You" message should be displayed
  Examples:
	|email           |mailid       |
	|qwerty@gmail.com|bob12@gmail.com|    
