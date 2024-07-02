#Author : Anjai K R

@RetuenAndExchangeFunctionality
Feature: Return and exchange Function

  @testreturnandexchange
  Scenario: Test Return and exchange function
    Given user is in the home page
    When the user scrolls down and clicks on the return/exchange link
    And is redirected to the return and exchange page
    And user Selects a "<Country>" from dropdown
    And clicks on getStarted button
    And enters the "<order number>" and "<zipcode>"
    Then "<Order not found>" error message is displayed.
  Examples:
	|Country           |order number       | zipcode  |Order not found
	|US                |643456784          | 235134   |Order not found
    