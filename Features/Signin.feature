Feature: Signin page

@Signin
Scenario: Signin with valid credentials

	Given The application is launched
	When The user entered valid username and password
	And The user hit the signin button
	Then The user signed in successfully