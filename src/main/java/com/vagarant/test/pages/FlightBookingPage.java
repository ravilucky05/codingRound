package com.vagarant.test.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.vagarant.test.base.TestBase;
import com.vagarant.test.util.TestUtil;

public class FlightBookingPage extends TestBase {

	@FindBy(className = "nextMonth")
	private WebElement nextMonth;

	@FindBy(className = "ui-datepicker-month")
	private List<WebElement> currentMonth;

	@FindBy(className = "ui-state-default ")
	private List<WebElement> totalDays;

	@FindBy(id = "toTag")
	private WebElement toField;

	@FindBy(id = "FromTag")
	private WebElement fromField;

	@FindBy(id = "OneWay")
	private WebElement oneWayButton;

	@FindBy(id = "SearchBtn")
	private WebElement searchButton;

	@FindBy(id = "Adults")
	private WebElement adults;

	public FlightBookingPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public void testThatResultsAppearForAOneWayJourney() {

		oneWayButton.click();

		fromField.clear();
		fromField.sendKeys(prop.getProperty("FromPlace"));

		// wait for the auto complete options to appear for the origin

		TestUtil.waitFor(5000);

		List<WebElement> placesSource = driver.findElements(By.xpath("//ul[contains(@id,'ui-id-1')]//li"));
		placesSource.get(0).click();

		List<WebElement> toes = driver.findElements(By.xpath("//*[@title='Any worldwide city or airport']"));

		toes.get(1).clear();
		toes.get(1).sendKeys(prop.getProperty("ToPlace"));

		TestUtil.waitFor(5000);

		// toField.clear();
		// toField.sendKeys(prop.getProperty("ToPlace"));

		List<WebElement> placesDest = driver.findElements(By.xpath("//ul[contains(@id,'ui-id-2')]//li"));

		placesDest.get(0).click();

		String dateArrIn[] = TestUtil.splitDate(prop.getProperty("flightDate"));
		String dayIn = dateArrIn[0];
		String monthIn = dateArrIn[1];
		String yearIn = dateArrIn[2];

		System.out.println("given day" + dayIn);

		String newmonth = "";

		// if it is todays date, differemt class,

		TestUtil.loopMonthandDay(currentMonth, dayIn, monthIn, nextMonth, totalDays);

		Select sel1 = new Select(adults);
		sel1.selectByValue("2");

		// all fields filled in. Now click on search
		searchButton.click();

		TestUtil.waitFor(5000);
		// verify that result appears for the provided journey search
		Assert.assertTrue(TestUtil.isElementPresent(By.className("searchSummary")));

	}

}
