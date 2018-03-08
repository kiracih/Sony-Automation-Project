package com.sony.test.stepDefinitions;

import com.sony.framework.driver.Driver;
import com.sony.framework.page.actions.ActionsCommon;
import com.sony.framework.page.assertions.AssertionsCommon;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepsCommon {

	AssertionsCommon assertion = new AssertionsCommon();
	ActionsCommon action = new ActionsCommon();
	
	@Given("^I navigate to \"([^\"]*)\" page on URL \"([^\"]*)\"$")
	public void i_navigate_to_page_on_URL(String arg1, String arg2) throws Throwable {
		
		Driver.goToURL(arg2);
		
	}
	
	@When("^I click on search in navigation bar$")
	public void i_click_search_in_nav_bar() throws Throwable {

		action.clickSearchBar();

	}
	
	@When("^I fill in search bar in navigation bar with \"([^\"]*)\"$")
	public void i_fill_in_search_bar_in_navbar_with(String arg1) throws Throwable {

		action.fillSearchBarWith(arg1);

	}
	
	@When("^I press enter$")
	public void i_press_enter() throws Throwable {
		
		action.performSearchByPressEnter();
		
	}
	
	@Then("^I should see \"([^\"]*)\" title$")
	public void i_should_see_title(String arg1) throws Throwable {
		
		assertion.assertTitle(arg1);
		
	}
	
	@Then("^I'm now on URL contains \"([^\"]*)\"$")
	public void i_am_on_url_contains(String arg1) throws Throwable {
		
		action.waitSec(1);
		assertion.assertUrlContains(arg1);
		
	}
	
	@Then("^I should see \"([^\"]*)\" button$")
	public void i_should_see_button(String arg1) throws Throwable {

		assertion.assertButton(arg1);

	}
	
	@When("^I click \"([^\"]*)\" button$")
	public void i_click_button(String arg1) throws Throwable {
		
		action.clickButton(arg1);
		
	}
	
}