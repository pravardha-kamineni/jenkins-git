Feature: Signing up for a LinkedIn account

  @SignUp
  Scenario: Sign up for linkedin
    Given I launched the application
    And I opened the sign up page
    When I enter a valid emailId or a valid mobile number
    And I enter a strong password
    And I click on Agree&Join
    Then I navigate to next page
    And I enter firstname and lastname
    And I click on continue
    Then I navigate to profile location page
    And I enter the country/region
    And I enter the city
    Then I click on continue
    And I redirect to LinkedIn feed page indicating a successful sign up
    
 
