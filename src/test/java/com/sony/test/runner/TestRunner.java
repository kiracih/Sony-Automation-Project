package com.sony.test.runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.sony.framework.driver.Driver;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.DriverManagerType;

@CucumberOptions(features = "src/test/resources/features", glue = { "com.sony.test.stepDefinitions" }, plugin = { "pretty",
		"html:target/cucumber" }, tags = {"@AcceptanceTest"})
public class TestRunner extends AbstractTestNGCucumberTests {

	@Parameters({"driverType"})
	@BeforeClass
	public void initializeTest(DriverManagerType driverType) {

		Driver.initiliaze(driverType);

	}

	@AfterClass
	public void cleanUp() {

		if (Driver.instance != null) {
			Driver.close();
		}
	}
}