package com.sony.framework.page.objects;

import java.util.List;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.sony.framework.driver.Driver;

public class SearchResultPage extends BasePage {

	public SearchResultPage() {

		PageFactory.initElements(Driver.instance, this);

	}

	@FindBy(how = How.CLASS_NAME, using = "results-summary")
	public WebElement resultSummary;
	
	@FindBy(how = How.CLASS_NAME, using = "zero-results")
	public WebElement zeroResult;

	@FindBy(how = How.CLASS_NAME, using = "clear-search")
	public WebElement searchCancel;

	@FindBy(how = How.CLASS_NAME, using = "search")
	public WebElement searchBar;

	@FindBy(how = How.CSS, using = ".btn.btn-large.btn-search")
	public WebElement searchButton;
	
	@FindAll(@FindBy(how = How.CSS, using = ".gsa-results .results-p .primary-link"))
	public List<WebElement> resultsList;
	
	@FindAll(@FindBy(how = How.CSS, using = ".community-results .results-p .primary-link"))
	public List<WebElement> communityResultsList;

	@FindAll(@FindBy(how = How.CSS, using = ".results-link-group .result"))
	public List<WebElement> filters;

	@FindBy(how = How.CSS, using = ".label.label-close")
	public WebElement filterRemove;
	
	@FindBy(how = How.CSS, using = ".gsa-results .btn.btn-alt-special.btn-alt-plus.search-more")
	public WebElement loadMoreButton;
	
	public By moreResultContainer = By.cssSelector("div.gsa-results > ul > li:nth-child(21)");

	public String[] getLinkTexts() {

		String linkTexts[] = new String[filters.size()];

		for (int i = 0; i < filters.size(); i++) {
			linkTexts[i] = filters.get(i).getText();
		}

		return linkTexts;
	}
	
	public TreeMap<String, String> textToFilterMap(){
		
		TreeMap<String, String> newMap = new TreeMap<String, String>();
		
		newMap.put("Electronics", "electronics");
		newMap.put("Entertainment", "entertainment");
		newMap.put("PlayStation", "playstation");
		newMap.put("Corporate", "corporate");
		newMap.put("Blogs", "social_community");
		newMap.put("Support", "support");
		
		return newMap;
	}

}