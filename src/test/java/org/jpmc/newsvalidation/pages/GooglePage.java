package org.jpmc.newsvalidation.pages;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.jpmc.newsvalidation.common.Config;
import org.jpmc.newsvalidation.common.Driver;
import org.jpmc.newsvalidation.common.Page;
import org.jpmc.newsvalidation.common.SeleniumCommon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {
	
	WebDriver driver;

	public GooglePage() throws Exception {
		driver = Driver.getDriverInstance();
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//input[@title = 'Search']")
	public WebElement googleTxtbox;
	
	
	@FindBy(xpath = "//input[@aria-label='Google Search']")
	public WebElement btnGSearch;
	

	public void searchNewsINGoogle(String newstosearch) throws Exception {
		SeleniumCommon scom = new SeleniumCommon();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		String gourl = Config.getConfigProperty("gurl");
		Driver.getDriverInstance().navigate().to(gourl);
		googleTxtbox.click();
		googleTxtbox.sendKeys(newstosearch);
		scom.JsClick(btnGSearch);
		Driver.getDriverInstance().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
}
