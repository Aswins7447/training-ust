#Author: ASWIN SATHIKUMAR
@chatfunctionality
Feature: To test chat functionality of AllBirds application

  @search-chat-valid-query
  Scenario: Search for query in chat
    Given user in Allbirds Home Page
    And user navigates to Product page
    When user clicks the chat icon
    And enters a valid chat query "<query>" in the search field
    Then user validate the results
	Examples: 
      |  query 	 |
      |  product |
      |  shoes   |
      
  @search-chat-invalid-query
  Scenario: Search for query in chat
    Given user in Allbirds Home Page
    And user navigates to Product page
    When user clicks the chat icon
    And enters a invalid chat query "<query>" in the search field
    Then user validate the appropriate  error results
Examples: 
      |  query 	 	 |
      | gibberish  |
      |  hello	   |
      
  @Support-team-available
  Scenario: verify if support team available or not
   Given user in Allbirds Home Page
    And user navigates to Product page
    When user clicks the chat icon
    Then user verifies if the support team is available or not
   
  @Successfully-closed-chatwindow
  Scenario: verify if the close-chat button closes the chat button
    Given user in Allbirds Home Page
    And user navigates to Product page
    When user clicks the chat icon
    And user click the close-chat icon
    Then the chat window closes successfully
   
      
      
      
