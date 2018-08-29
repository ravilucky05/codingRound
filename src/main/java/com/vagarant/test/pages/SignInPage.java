package com.vagarant.test.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.vagarant.test.base.TestBase;
import com.vagarant.test.util.TestUtil;

public class SignInPage extends TestBase {

	@FindBy(linkText = "Your trips")
	WebElement lnktext;

	@FindBy(id = "SignIn")
	WebElement signIn;

	@FindBy(id = "signInButton")
	WebElement signInButton;

	public SignInPage() throws IOException {

		PageFactory.initElements(driver, this);

	}

	public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

		// setDriverPath();
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Users\\varanar.UTCCGL\\Downloads\\chromedriver.exe"); driver =
		 * new ChromeDriver();
		 */

		lnktext.click();
		signIn.click();

		TestUtil.switchToFrame("modal_window");

		signInButton.click();// signInButton

		String errors1 = driver.findElement(By.id("errors1")).getText();
		Assert.assertTrue(errors1.contains("There were errors in your submission"));

	}

	private void waitFor(int durationInMilliSeconds) {
		try {
			Thread.sleep(durationInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}
	}

	/*
	 * private void setDriverPath() { if (PlatformUtil.isMac()) {
	 * System.setProperty("webdriver.chrome.driver", "chromedriver"); } if
	 * (PlatformUtil.isWindows()) {
	 * System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); } if
	 * (PlatformUtil.isLinux()) { System.setProperty("webdriver.chrome.driver",
	 * "chromedriver_linux"); } }
	 */

}
