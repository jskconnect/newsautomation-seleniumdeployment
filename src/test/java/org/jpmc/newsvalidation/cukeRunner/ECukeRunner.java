package org.jpmc.newsvalidation.cukeRunner;

import org.apache.log4j.Logger;
import org.jpmc.newsvalidation.common.Config;
import org.jpmc.newsvalidation.common.Driver;
import org.jpmc.newsvalidation.common.Page;
import org.jpmc.newsvalidation.common.SeleniumCommon;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources" }, glue = { "org.jpmc.newsvalidation.stepdefinitions" }, tags = {
		"@searchConfirmNews" }, monochrome = true, dryRun = false, plugin = { "html:target/cucumber",
				"json:target/cucumber-reports/cucumber.json" })

public class ECukeRunner {

	static Logger log = Logger.getLogger(ECukeRunner.class);
	
	@BeforeClass
	public static void runnerSetup() throws Exception {

		if (Driver.getDriverInstance() != null) {
			Driver.getDriverInstance().manage().deleteAllCookies();
		}
	
	}

	@AfterClass
	public static void manageAfterclassReport() throws Exception {
		
		Driver.getDriverInstance().quit();
		log.info("after class method");
		
	}

}
