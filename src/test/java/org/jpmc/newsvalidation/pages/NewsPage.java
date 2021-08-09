package org.jpmc.newsvalidation.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jpmc.newsvalidation.common.Config;
import org.jpmc.newsvalidation.common.Driver;
import org.jpmc.newsvalidation.common.Page;
import org.jpmc.newsvalidation.common.SeleniumCommon;
import org.jpmc.newsvalidation.common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsPage {

	WebDriver driver;
	public HashMap<String, String> globalmap = new HashMap<String, String>();
	public String gblfieldnewsparam;

	public NewsPage() throws Exception {
		driver = Driver.getDriverInstance();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(), 'Swimming Australia boss Alex Baumann quits after three')]")
	public WebElement lnkEms;

	@FindBy(xpath = "//button[@title='Yes, I’m happy']")
	public WebElement linkYes;

	@FindBy(xpath = "//a[contains(text(), 'News')]")
	public WebElement lnkNews;

	public void launchApplication() throws Exception {
		String appurl = Config.getConfigProperty("qaenvironmenturl");
		Driver.getDriverInstance().navigate().to(appurl);
		Page.sleep(Config.getConfigProperty("mwait"));
	}

	public void clickYes() throws Exception {

		SeleniumCommon scom = new SeleniumCommon();
		scom.switchToIframe("sp_message_iframe_514494");
		Driver.getDriverInstance().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		scom.getElementOnceAvailable(linkYes, 7);
		scom.JsClick(linkYes);
		Driver.getDriverInstance().switchTo().defaultContent();
		Driver.getDriverInstance().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	public void confirmNewsValid() throws Exception {
		String strsearchnews = null;
		GooglePage gp = new GooglePage();
		SeleniumCommon scom = new SeleniumCommon();
		scom.getElementOnceAvailable(lnkEms, 4);

		strsearchnews = scom.getElementText(lnkEms);
		System.out.println(strsearchnews);
		globalmap.put("newstoSearch", strsearchnews);

		Utilities.openNewTab();

		gp.searchNewsINGoogle(globalmap.get("newstoSearch"));
		Driver.getDriverInstance().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		// Search News in google page - selenium Element Match
		scom.searchElementsInPage(globalmap.get("newstoSearch"), "vaccine");

		// using page source
		scom.readPageSource(globalmap.get("newstoSearch"));

		// Read all links text
		scom.getAllElementLinks(globalmap.get("newstoSearch"));

	}

	public boolean confirmNewsingoogle(String newstosch) throws Exception {
		String strsearchnews = null;
		GooglePage gp = new GooglePage();
		SeleniumCommon scom = new SeleniumCommon();
		scom.getElementOnceAvailable(lnkEms, 4);

		strsearchnews = scom.getElementText(lnkEms);
		System.out.println(strsearchnews);
		globalmap.put("newstoSearch", strsearchnews);

		Utilities.openNewTab();

		gp.searchNewsINGoogle(globalmap.get("newstoSearch"));
		Driver.getDriverInstance().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		// Search News in google page - selenium Element Match
		return scom.searchElementsInPage(globalmap.get("newstoSearch"), newstosch);

	}

	public boolean verifyNewsSearchElements(String fieldname, List<List<String>> news) throws Exception {
		System.out.println("datatable list value is :" + news.get(0).get(0));
		String strsearchnews = null;
		GooglePage gp = new GooglePage();
		WebElement wenews = Driver.getDriverInstance()
				.findElement(By.xpath("//span[contains(text(), '" + news.get(0).get(0) + "')]"));
		SeleniumCommon scom = new SeleniumCommon();
		scom.getElementOnceAvailable(wenews, 4);

		strsearchnews = scom.getElementText(wenews);
		System.out.println(strsearchnews);
		globalmap.put("newstoSearch", strsearchnews);

		Utilities.openNewTab();

		gp.searchNewsINGoogle(globalmap.get("newstoSearch"));
		Driver.getDriverInstance().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		// Search News in google page - selenium Element Match
		return scom.searchElementsInPage(globalmap.get("newstoSearch"), fieldname);
	}

	public boolean verifyNewsReadPageSource() throws Exception {
		SeleniumCommon scom = new SeleniumCommon();
		// Search News in google page - Page Source
		return scom.readPageSource(globalmap.get("newstoSearch"));
	}

	public void verifyNewsReadElementLinks() throws Exception {
		SeleniumCommon scom = new SeleniumCommon();
		// Read all links text
		scom.getAllElementLinks(globalmap.get("newstoSearch"));
	}

}
