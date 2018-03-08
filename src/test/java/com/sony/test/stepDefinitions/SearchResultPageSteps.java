package com.sony.test.stepDefinitions;

import static com.sony.framework.page.actions.SearchActionType.CLICK_SEARCH;
import static com.sony.framework.page.actions.SearchActionType.PRESS_ENTER;

import com.sony.framework.page.actions.SearchActionType;
import com.sony.framework.page.actions.SearchResultPageActions;
import com.sony.framework.page.assertions.SearchResultPageAssertions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchResultPageSteps{

	SearchResultPageActions searchAction = new SearchResultPageActions();
	SearchResultPageAssertions searchAssertion = new SearchResultPageAssertions();
	
	private int resultCount;
	
	public int getResultCount() {
		return resultCount;
	}

	public void setResultCount(int resultCount) {
		this.resultCount = resultCount;
	}

	@When("^I perform search by \"([^\"]*)\"$")
	public void i_perform_search(SearchActionType arg1) throws Throwable {
		
		if(arg1.equals(CLICK_SEARCH))
			searchAction.performSearchByClickSearch();
		else if(arg1.equals(PRESS_ENTER))
			searchAction.performSearchByPressEnter();
		else
		{
			System.out.println("Given search command not recognized, pressing Enter...");
			searchAction.performSearchByPressEnter();
		}
		
		searchAction.waitSec(1);
	}
	
	@When("^I fill in search with \"([^\"]*)\"$")
	public void i_fill_in_searchBar_with(String arg1) throws Throwable {

		searchAction.fillSearchBarWith(arg1);

	}
	
	@Then("^I should see results more than zero$")
	public void i_should_see_message() throws Throwable {

		searchAssertion.assertResultCount();

	}
	
	@Then("^I should see \"(.*)\" zero message$")
	public void i_should_see_zero_result(String arg1) throws Throwable {

		searchAssertion.assertZeroResult(arg1);

	}
	
	@Then("^I should see filters working properly by clicking on them$")
	public void i_click_filters() throws Throwable {
		
		searchAction.narrowDown();
		searchAction.waitSec(5);
		
	}
	
	@When("^I click load more button$")
	public void i_click_load_more() throws Throwable {
		
		searchAction.clickLoadMoreButton();
		
	}
	
	@Then("^Results count shown in current page should be increased")
	public void results_count_should_be_increased() throws Throwable {
		
		searchAssertion.assertMoreResultLoaded();
		System.out.println(getResultCount() + " " + searchAssertion.getResultCount());
		
	}
	
	@Then("^All filters should be valid$")
	public void filter_valid() throws Throwable {
		
		searchAssertion.assertFiltersValid();
		
	}
	
	@Then("^All results should be valid$")
	public void result_valid() throws Throwable {
		
		searchAssertion.assertResultsValid();
		
	}
	
	@Then("^I should see relevant results$")
	public void i_see_results() throws Throwable {
		
		searchAssertion.assertResultsLoaded();
		setResultCount(searchAssertion.getResultCount());
	}
	
}