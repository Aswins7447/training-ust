# Weather Website using BDD framework
@search
Feature: Search functionality
  
	Background: Preconditions
	 Given user is in the home page
	
  @valid
  Scenario: Valid search  
    When user enters the valid <search item> in the search bar
    And selects the item from the dropdown
    Then the search result page is displayed
    Examples: 
      | search item | 
      | Bengaluru |        

  @invalid
  Scenario Outline: Invalid search
    When user enters the invalid <search item> in the search bar
    Then the home page is displayed
   Examples: 
      | search item | 
      | _$2Bengaluru |  
