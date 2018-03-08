package com.sony.framework.page.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.sony.framework.driver.Driver;

public class BasePage {
	
	public BasePage() {
		
		PageFactory.initElements(Driver.instance, this);
		
	}

	@FindBy(how = How.CSS, using = ".nav-li.nav-li-search")
	public WebElement searchBar;

	@FindBy(how = How.ID, using = "nav-search-input")
	public WebElement searchInput;
	
	@FindAll(@FindBy(how = How.TAG_NAME, using = "button"))
	public List<WebElement> buttons;

}