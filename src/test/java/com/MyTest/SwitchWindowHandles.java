/**
 *
 */
package com.MyTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Page.BasePage;

/**
 * @author W252625
 *
 */
public class SwitchWindowHandles extends BasePage {


	public SwitchWindowHandles(WebDriver driver) {
		super(driver);

	}
	
	// implicit wait is declared one at the global level / or class level
	// Implicit wait will give the page to find the particual element upto 15 seconds (standard)
	// sntax is  driver.manage().timeouts().implicitwait(int number, timeunit milliseconds)
	

	private By clickbutton = By.id("");

		// manual test case> when automation is done - scripting
	//multople
	public void checkImplicit(WebDriver driver) throws Throwable{
		driver.get("http://google.com");
		// declared globally - called one time . 
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
		
		driver.findElement(clickbutton);
		driver.findElement(By.id("test")).click();
		
		driver.findElement(clickbutton);
		driver.findElement(By.id("test")).click();

		// explicit wait // 



	}
	public void checkExplicit(WebDriver driver, By locator ){
		//focus on a particualr element 
		driver.findElement(clickbutton);
		driver.findElement(By.id("test")).click();
		WebDriverWait a = new WebDriverWait(driver,5);
		// visiblity is to wait to see when the page is loading and waits for the element to be visible on the page and then does some action
		a.until(ExpectedConditions.visibilityOfElementLocated(locator));
		a.until(ExpectedConditions.elementToBeClickable(locator));
		// presence will wait for a element when the page is loading to see if the element does exist on page then execution will resume. 
		a.until(ExpectedConditions.presenceOfElementLocated(locator));
		
		// visiblity 
		
		
			// we can wait for a particualar element to appear or to check if the locater is there. 
	
	}

}
