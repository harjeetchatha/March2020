/**
 *
 */
package com.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author Harjeet
 *
 */
public class BasePage extends Page {

	public BasePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	public String getPageTitle(String title) {
		try{
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
		}
		catch(Exception e){
			return null;
		}

	}

	@Override
	public String getPageHeader(By locator) {
	return	getElement(locator).getText();

	}

	@Override
	public WebElement getElement(By locator) {
	WebElement element = null;
		try{
			waitForElementPresent(locator);
			element = driver.findElement(locator);
			return element;
		}
		catch(Exception e){
			System.err.println("Some error has occure while waiting for the element: "+ element);

		}
		return element;
	}

	@Override
	public WebElement waitForElementPresent(By locator) {
		WebElement element = null;
		try{
			element=wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}
		catch(Exception e){
			System.err.println("Some error has occure while waiting for the element" + locator.toString());
			e.printStackTrace();

		}
		return element;

	}


	@Override
	public String getPageTitle(By locator) {
		// TODO Auto-generated method stub
		return null;
	}





}
