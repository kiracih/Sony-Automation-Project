@Filter 
Feature: Search Functionality in Search Result Page

Background: User navigates to Sony search page 
	Given I navigate to "Sony Search" page on URL "https://www.sony.com/search?query=" 
	Then I should see "Search Results | Sony US" title 
	And I should see "Search" button 
	
@AcceptanceTest 
Scenario: Search with a valid search term 
	When I fill in search with "television" 
	And I click "Search" button 
	Then I should see results more than zero 
	And All results should be valid 
	
@AcceptanceTest 
Scenario: Meaningless search term with zero result 
	When  I fill in search with "asdfghjkl" 
	And  I click "Search" button 
	Then  I should see "Your search for "asdfghjkl" returned 0 results" zero message 
	
@AcceptanceTest 
Scenario: Load More Results 
	When  I fill in search with "mobile phone" 
	And  I click "Search" button 
	Then  I should see "Load More" button 
	When  I click "Load More" button 
	Then  Results count shown in current page should be increased 
	
@AcceptanceTest
Scenario: Filtering the results 
	When  I fill in search with "headphone" 
	And  I click "Search" button 
	Then  All filters should be valid 
	And I should see filters working properly by clicking on them 
	
@AcceptanceTest 
Scenario Outline: Search in search page by two different actions 
	When   I fill in search with "mobile phone" 
	And   I perform search by "<action>" 
	Then    I should see results more than zero 
	Examples: 
		|action|
		|CLICK_SEARCH|
		|PRESS_ENTER|