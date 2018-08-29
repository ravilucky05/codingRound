package com.vagarant.test.tests;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
/*import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;*/
import org.testng.annotations.Test;

/*import com.sun.javafx.PlatformUtil;*/
import com.vagarant.test.base.TestBase;
import com.vagarant.test.pages.SignInPage;

public class SignInTest extends TestBase {

	SignInPage signinPage;

	public SignInTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@org.testng.annotations.BeforeMethod
	public void setUp() throws IOException {
		initialization();

		signinPage = new SignInPage();

	}

	@Test
	public void Login() {

		signinPage.shouldThrowAnErrorIfSignInDetailsAreMissing();
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

}
