
@Restful-api
Feature: Get single Object

  Background: 
    * url 'https://api.restful-api.dev/objects'
    * configure ssl = true

	@tag
  Scenario: Retrieve single Object
    Given path '/8'
    * def schema = read('classpath:getsingleobject.json')
	 And header Content-Type = 'application/json'
    When method GET
    Then status 200
    And match response.data.id == '7'
    And match response.data.name == 'Apple MacBook Pro 16'
    And match response.data.year == 2019
    And match response.data.price == 1849.99
    And match response.data.CPU model == 'Intel Core i9'
    And match response.data.Hard disk size == '1 TB'
    And match response == schema
    
  @tag  
  Scenario: Retrieve Object by id
    Given path '?id=3&id=5&id=10'
	 And header Content-Type = 'application/json'
    When method GET
    Then status 200
    And match response.data.id == '3'
  
  @tag  
  Scenario: Create Objects <object>
    Given path ''
	 	And header Content-Type = 'application/json'
    And request
      """
      "id": "ff808181900c10e80190110ab50c0959",
    	"name": "Apple MacBook Pro 16",
      """
    When method post
    Then status 200
    Then print response

    Examples: 
      | user | name |
      | test | Apple MacBook Pro 16  |
    
  @tag  
  Scenario: Update Objects <object>
    Given path ''
	 	And header Content-Type = 'application/json'
    And request
      """
      "id": "ff808181900c10e80190110ab50c0959",
    	"name": "Apple MacBook Pro 16",
      """
    When method post
    Then status 200
    Then print response

    Examples: 
      | user |name |
      | test |google |
    
    

 
    
    
    