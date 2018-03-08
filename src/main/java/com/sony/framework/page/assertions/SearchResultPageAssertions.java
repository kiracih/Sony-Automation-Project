package com.sony.framework.page.assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.sony.framework.driver.Driver;
import com.sony.framework.page.objects.SearchResultPage;

public class SearchResultPageAssertions extends AssertionsCommon {

	SearchResultPage sPage = new SearchResultPage();
	
	private int resultCount;

	public int getResultCount() {
		return resultCount;
	}

	public void setResultCount(int resultCount) {
		this.resultCount = resultCount;
	}

	public void assertResultCount() {

		Assert.assertTrue(Integer.parseInt(sPage.resultSummary.getText().split(" ")[0]) > 0);

	}
	
	public void assertZeroResult(String message) {
		
		Assert.assertTrue(sPage.zeroResult.getText().equals(message));
	}

	public void assertFiltersValid() throws Exception {

		for (int i = 0; i < sPage.getLinkTexts().length; i++) {
			String url = Driver.instance.findElement(By.linkText(sPage.getLinkTexts()[i])).getAttribute("href");
			assertUrlValidity(url);
		}

	}
	
	public void assertResultsLoaded() {
		
		Assert.assertNotNull(sPage.resultsList);
		setResultCount(sPage.resultsList.size());
		
	}

	public void assertResultsValid() throws Exception {

		for (WebElement result : sPage.resultsList) {
			assertUrlValidity(result.getAttribute("href"));
		}
	}

	public void assertMoreResultLoaded() {
		
		System.out.println(getResultCount());
		Assert.assertTrue(sPage.resultsList.size() > getResultCount());
		setResultCount(sPage.resultsList.size());

	}

}