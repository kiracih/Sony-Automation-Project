package com.sony.framework.page.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.sony.framework.driver.Driver;
import com.sony.framework.page.assertions.AssertionsCommon;
import com.sony.framework.page.objects.SearchResultPage;

public class SearchResultPageActions extends ActionsCommon {

	SearchResultPage sPage;
	AssertionsCommon assertion = new AssertionsCommon();

	private int resultCount;

	public int getResultCount() {
		return resultCount;
	}

	private void setResultCount(int resultCount) {
		this.resultCount = resultCount;
	}

	public void performSearchByClickSearch() {

		sPage = new SearchResultPage();
		click(sPage.searchButton);

	}

	@Override
	public void performSearchByPressEnter() {

		sPage = new SearchResultPage();
		pressKey(sPage.searchBar, "RETURN");

	}

	public void cancelSearch() {

		sPage = new SearchResultPage();
		click(sPage.searchCancel);

	}

	@Override
	public void fillSearchBarWith(String searchTerm) {

		sPage = new SearchResultPage();
		fillInWith(sPage.searchBar, searchTerm);

	}

	public void narrowDown() throws InterruptedException {

		sPage = new SearchResultPage();

		String linkTexts[] = sPage.getLinkTexts();
		for (int i = 0; i < linkTexts.length; i++) {
			if (Driver.instance.findElement(By.linkText(linkTexts[i])).getAttribute("href")
					.contains("//www.sony.com/search?query=")) {
				WebElement element = Driver.instance.findElement(
						By.xpath("//div[contains(@class,'results-link-group')]/descendant::a[contains(text(), '"
								+ linkTexts[i] + "')]"));
				click(element);
				waitSec(5);
				assertion.assertUrlContains("filter=" + sPage.textToFilterMap().get(linkTexts[i].split(" ")[0]));
				click(sPage.filterRemove);
			}
		}
	}

	public void clickLoadMoreButton() {

		setResultCount(sPage.resultsList.size());

		click(sPage.loadMoreButton);
		waitForPresence(sPage.moreResultContainer);

	}
}