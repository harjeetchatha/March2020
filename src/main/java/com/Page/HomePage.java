/**
 *
 */
package com.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author W252625
 *
 */
public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);

	}

	private By pageTitle = By.id("example");


	public WebElement getPageTitle() {
		return getElement(pageTitle);
	}

		public String getHomePageHeader(){

			return getPageHeader(pageTitle);
		}
	}






