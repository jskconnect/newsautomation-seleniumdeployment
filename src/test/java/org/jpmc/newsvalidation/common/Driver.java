package org.jpmc.newsvalidation.common;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

	private static WebDriver driver;
	static Logger log = Logger.getLogger(Driver.class);
	
	public static WebDriver getDriverInstance() throws Exception {

		if (driver == null) {
			String path = System.getProperty("user.dir");
			String chromepath = Config.getConfigProperty("chromedriverpath");
			System.setProperty("webdriver.chrome.driver", path+chromepath);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			

		}

		return driver;
	}

	
	public static void closeDriver() throws Exception {
		try {
			if (driver != null) {
				driver.quit();
			}
		} catch (Exception e) {
			
			log.info("News Present :" + e.getMessage());
		}

	}

}
