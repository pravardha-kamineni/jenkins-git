@petstore
Feature: Validate petstore 

  Scenario Outline: Login with valid credentials
    Given I navigate to Sign in page
    When I enter user credentials "<username>" "<password>"
    And I click on login button
    Then I navigate to welcome page

    Examples: 
      | username  | password |
      | j2ee 			|     j2ee |		
	
	Scenario: Validate submit order - 1
		Given I navigate to welcome page
		When I choose the type of pet i want to buy 
		| Fish | FI-SW-01 | EST-1 |
		And I add the item to cart 
		And I click on proceed to checkout  
		And I confirm the order
		Then I verify the order in MyOrder section
		
	Scenario: Validate submit order - 2
		Given I am on welcome page
		When I choose the type of pet i want to buy 
		| Birds| AV-CB-01 | EST-18|
		And I add the item to cart 
		And I click on proceed to checkout
		And I confirm the order
		Then I verify the order in MyOrder section
