/**
 *
 */
package com.Page;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * @author W252625
 *
 */
public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By userName = By.id("user-name");

	private By password = By.id("password");

	private By logIn = By.xpath("//input[contains(@value,'LOGIN')]");

	private By lastNameList = By.xpath("(//table)[1]//td[1]");

	private By lastNameLink = By.xpath("(//span[.='Last Name']/..)[12]");

	private By clickHereLink = By.xpath("//a[contains(.,'Click Here')]");

	private By pageHeader = By.tagName("h3");

	public void checkSortingExample() throws Throwable {
		driver.get("http://the-internet.herokuapp.com/tables");
		driver.manage().window().maximize();
		// navigate to the Last name link and click.
		driver.findElement(lastNameLink).click();
		Thread.sleep(2000);
		List<WebElement> firstCollectionList = driver.findElements(lastNameList);

		ArrayList<String> originalList = new ArrayList<String>();

		for (int i = 0; i < firstCollectionList.size(); i++) {
			originalList.add(firstCollectionList.get(i).getText());
			System.err.println();
		}

		ArrayList<String> copiedLIst = new ArrayList<String>();

		for (int i = 0; i < originalList.size(); i++) {

			copiedLIst.add(originalList.get(i));

		}

		Collections.sort(copiedLIst);
		// TODO check how the reverse logic works
		// Collections.reverse(copiedLIst);

		for (String originalListAftersort : originalList) {
			System.err.println(originalListAftersort);
		}

		for (String copiedListAfter : copiedLIst) {
			System.out.println(copiedListAfter);

		}

		Assert.assertTrue(originalList.equals(copiedLIst));
	}

	// verify sorting .
	public void verifyShorting() throws InterruptedException {
		getLastNameLink().click();
		Thread.sleep(2000);
		List<WebElement> lastNameListBeforeShort = driver.findElements(lastNameList);
		for (WebElement webElement : lastNameListBeforeShort) {
			System.err.println(webElement.getText());
		}
		String lastNameFirstValueB = lastNameListBeforeShort.get(0).getText().trim();
		String lastNameLastValueB = lastNameListBeforeShort.get(lastNameListBeforeShort.size() - 1).getText().trim();
		getLastNameLink().click();
		Thread.sleep(2000);
		List<WebElement> lastNameListAfterShort = driver.findElements(lastNameList);
		for (WebElement webElement : lastNameListAfterShort) {
			System.err.println(webElement.getText());
		}
		String lastNameFirstValueA = lastNameListAfterShort.get(0).getText().trim();
		String lastNameLastValueA = lastNameListAfterShort.get(lastNameListBeforeShort.size() - 1).getText().trim();

		Assert.assertEquals(lastNameFirstValueB, lastNameLastValueA);
		Assert.assertEquals(lastNameLastValueB, lastNameFirstValueA);
		System.err.println("Sorting is working fine ");
	}

	public WebElement getLastNameLink() {
		return getElement(lastNameLink);
	}

	public WebElement getLogIn() {
		return getElement(logIn);
	}

	public WebElement getUserName() {
		return getElement(userName);
	}

	public WebElement getPassword() {
		return getElement(password);
	}

	public LoginPage doLogin(String userName, String password) {
		getUserName().sendKeys(userName);
		getPassword().sendKeys(password);
		getLogIn().click();

		return getInstance(LoginPage.class);
	}

	public void checkSwitchtoPage() throws Throwable {
		driver.get("http://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize();
		System.err.println("Page title before switch : " + driver.getTitle());
		System.err.println("Page header before switch : " + driver.findElement(pageHeader).getText());
		driver.findElement(clickHereLink).click();
		Thread.sleep(2000);
		switchToWindowIndex(1);
		//do some stuff
		System.err.println("Page header after switch : " + driver.findElement(pageHeader).getText());
		switchToWindowIndex(0);
		System.err.println("Page header after switch : " + driver.findElement(pageHeader).getText());
	}

	public void switchToWindowIndex(int index) {

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowStrings = new ArrayList<String>(windowHandles);
		//passing index value to get list elements
		String reqWindow = windowStrings.get(index);
		System.err.println("Window id is : " + reqWindow);
		driver.switchTo().window(reqWindow);
		System.err.println("Page title after switch : " + driver.getTitle());
		// logger.info("Switched to " + driver.getTitle());
	}

}
