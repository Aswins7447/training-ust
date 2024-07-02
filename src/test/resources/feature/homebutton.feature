#Author: ASWIN SATHIKUMAR
@HomeButtonFunctionality
Feature: To test the AllBirds Home button

  @check-home-button
  Scenario: verify Allbirds Home button
    Given I am in Allbirds Home Page
    And user navigates to the rerun page
    When user clicks the AllBirds Home button
    Then user should be in AllBirds Home page.
