@Filter 
Feature: Search Functionality in Navigation Bar Search 
@AcceptanceTest
Scenario Outline: Successful search on different pages 
	Given I navigate to "<pages>" page on URL "<pagesURLs>" 
	When I click on search in navigation bar 
	And I fill in search bar in navigation bar with "<searchTerm>" 
	And I press enter 
	Then I'm now on URL contains "sony.com/search?query=<searchTerm>"
	And All results should be valid
	Examples: 
		|pages|pagesURLs|searchTerm|
		|Sony Home|https://www.sony.com/|phone|
		|Sony PlayStation|https://www.sony.com/electronics/playstation|joystick|
		|Sony Support|https://esupport.sony.com/|help|
		|Sony Community|https://community.sony.com/|bravia|