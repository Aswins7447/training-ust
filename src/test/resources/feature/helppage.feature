#Author: ANNA SUSAN JOSE
@helppagevalidation
Feature: helpsspage
  validating the helppage

  @help
  Scenario: validating the helppage
    Given User is on the homepage.
    Then click on the FAQ/Contact Us link on help.
    And click on the appropriate  FAQ.
    And click on the back option.
