/**
 *
 */
package com.MyTest;

import org.testng.annotations.Test;

import com.Page.LoginPage;

/**
 * @author W252625
 *
 */
public class LoginTest extends BaseTest{


	/*
	 * http://the-internet.herokuapp.com/tables
	 *
	 * check if the list is in descending order and acceding.
	 */


	@Test(priority=1, enabled = false)
	public void doLogin(){
		page.getInstance(LoginPage.class).doLogin("standard_user", "secret_sauce");

	}

	@Test(priority=1, enabled = false)
	public void checkSorting() throws Throwable{
		page.getInstance(LoginPage.class).verifyShorting();

	}

	@Test(priority=1, enabled = true)
	public void checkTableSorting() throws Throwable{
		page.getInstance(LoginPage.class).checkSortingExample();

	}

	@Test(priority=1, enabled = false)
	public void checkWindowHandlesSwitching() throws Throwable{
		page.getInstance(LoginPage.class).checkSwitchtoPage();

	}
	@Test(priority=1, enabled = false)
	public void ExampleSwitchWindows(){

	}

}
