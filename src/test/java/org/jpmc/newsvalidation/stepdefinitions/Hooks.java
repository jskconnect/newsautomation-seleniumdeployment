package org.jpmc.newsvalidation.stepdefinitions;

import org.jpmc.newsvalidation.common.Config;
import org.jpmc.newsvalidation.common.Driver;
import org.jpmc.newsvalidation.common.Page;
import org.jpmc.newsvalidation.pages.NewsPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	@Before
	public void beforeScenario() throws Exception{
		if(Driver.getDriverInstance() == null){
		      
			Driver.getDriverInstance();
		    }
	}

	@After
	public void afterScenario() throws Exception {
		
		
				Driver.getDriverInstance().close();
				Page.sleep(Config.getConfigProperty("mwait"));
	}
	
	
}
