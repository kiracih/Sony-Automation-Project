package com.sony.framework.page.assertions;

import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.testng.Assert;

import com.sony.framework.driver.Driver;

public class AssertionsCommon {
	
	public void assertUrlValidity(String link) throws Exception {
		
		URL url = new URL(link);
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		System.out.println(url + " " + http.getResponseCode());
		Assert.assertTrue(http.getResponseCode() == 200 || http.getResponseCode() == 302);
		
	}
	
	public void assertTitle(String title) {
		
		Assert.assertEquals(Driver.instance.getTitle(), title);
		
	}
	
	public void assertUrlContains(String parameter) {
		
		Assert.assertTrue(Driver.instance.getCurrentUrl().contains(parameter));
		
	}
	
	public void assertButton(String buttonText) {

		WebElement button = Driver.instance.findElement(
				new ByChained(By.tagName("button"), By.xpath("//*[contains(text(), '" + buttonText + "')]")));

		Assert.assertNotNull(button);

	}

}