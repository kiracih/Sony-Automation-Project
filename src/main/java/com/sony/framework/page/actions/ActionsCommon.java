package com.sony.framework.page.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sony.framework.driver.Driver;
import com.sony.framework.page.objects.BasePage;

public class ActionsCommon {

	BasePage bPage = new BasePage();

	public void click(WebElement element) {

		element.click();

	}

	public void pressKey(WebElement element, String key) {

		try {
			element.sendKeys(Keys.valueOf(key));
		} catch (Exception e) {
			System.out.println(e.getMessage() + " " + e.getCause());
		}

	}

	public void fillInWith(WebElement element, String fillWord) {

		element.clear();
		element.sendKeys(fillWord);

	}

	public void waitSec(int seconds) throws InterruptedException {

		// Driver.instance.manage().timeouts().implicitlyWait(seconds,
		// TimeUnit.SECONDS);
		Thread.sleep(seconds * 1000);
	}

	public void waitForPresence(By container) {

		WebDriverWait wait = new WebDriverWait(Driver.instance, 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(container));

	}

	public void waitForVisible(WebElement element) {

		WebDriverWait wait = new WebDriverWait(Driver.instance, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void performSearchByPressEnter() {

		pressKey(bPage.searchInput, "RETURN");

	}

	public void clickSearchBar() {

		click(bPage.searchBar);

	}

	public void fillSearchBarWith(String searchTerm) {

		fillInWith(bPage.searchInput, searchTerm);

	}

	public void clickButton(String buttonText) {

		WebElement button = Driver.instance.findElement(
				By.xpath("//button[(text() = '" + buttonText + "') or ./*/text() = '" + buttonText + "']"));
		button.click();

	}

}