package com.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {


	WebDriver driver;
	WebDriverWait wait;

	public Page(WebDriver driver){

		this.driver = driver;
		 wait = new WebDriverWait(this.driver, 15);

	}

	public abstract String getPageTitle(By locator);
	public abstract String getPageHeader(By locator);
	public abstract WebElement getElement(By locator);
	public abstract WebElement waitForElementPresent(By locator);

	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageCLass){
		 try {
		 return pageCLass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		 }
		 catch(Exception e){
			 e.printStackTrace();
			 return null;

		 }
	 }

}
