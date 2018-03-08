package com.sony.framework.driver;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import static io.github.bonigarcia.wdm.DriverManagerType.EDGE;
import static io.github.bonigarcia.wdm.DriverManagerType.FIREFOX;
import static io.github.bonigarcia.wdm.DriverManagerType.IEXPLORER;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	public static WebDriver instance;

	public static void initiliaze(DriverManagerType browserType) {

		switch (browserType) {
		case CHROME:
			WebDriverManager.getInstance(CHROME).setup();
			instance = new ChromeDriver();
			break;
		case FIREFOX:
			WebDriverManager.getInstance(FIREFOX).setup();
			instance = new FirefoxDriver();
			break;
		case IEXPLORER:
			WebDriverManager.getInstance(IEXPLORER).setup();
			instance = new InternetExplorerDriver();
			break;
		case EDGE:
			WebDriverManager.getInstance(EDGE).setup();
			instance = new EdgeDriver();
			break;
		default:
			WebDriverManager.getInstance(CHROME).setup();
			instance = new ChromeDriver();
			break;
		}

		instance.manage().window().maximize();

	}

	public static void goToURL(String url) {

		instance.navigate().to(url);

	}

	public static void close() {

		instance.quit();
	}
}
