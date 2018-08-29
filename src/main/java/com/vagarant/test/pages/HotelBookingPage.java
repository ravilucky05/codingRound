package com.vagarant.test.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vagarant.test.base.TestBase;
import com.vagarant.test.util.TestUtil;

public class HotelBookingPage extends TestBase {

	@FindBy(xpath = ".//a[contains(@title,'Find hotels in destinations around the world')]")
	private WebElement hotelLink;

	@FindBy(id = "Tags")
	private WebElement localityField;

	@FindBy(id = "SearchHotelsButton")
	private WebElement searchButton;

	@FindBy(id = "travellersOnhome")
	private WebElement travellerSelection;

	@FindBy(id = "CheckInDate")
	private WebElement calendarIconIn;

	@FindBy(id = "CheckOutDate")
	private WebElement calendarIconOut;

	@FindBy(className = "ui-datepicker-month")
	private WebElement monthVal;

	@FindBy(className = "ui-datepicker-year")
	private WebElement yearVal;

	@FindBy(className = "nextMonth")
	private WebElement nextMonth;

	@FindBy(className = "ui-datepicker-month")
	private List<WebElement> currentMonth;

	@FindBy(className = "ui-state-default ")
	private List<WebElement> totalDays;

	String Loc = prop.getProperty("Location");

	public HotelBookingPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public void shouldBeAbleToSearchForHotels() throws InterruptedException {

		WebDriverWait wait1 = new WebDriverWait(driver, 500);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(
				(By.xpath(".//a[contains(@title,'Find hotels in destinations around the world')]")))).click();

		localityField.sendKeys(Loc);
		Thread.sleep(10000);
		// autosuggest

		List<WebElement> autoSuggetOptions = driver.findElements(By.xpath(".//a[contains(text(),'" + Loc + "')]"));

		autoSuggetOptions.get(0).click();

		calendarIconIn.click();

		// String date = prop.getProperty("jDate");
		String checkInDate = "30-September-2018";

		String dateArrIn[] = TestUtil.splitDate(checkInDate);
		String dayIn = dateArrIn[0];
		String monthIn = dateArrIn[1];
		String yearIn = dateArrIn[2];

		System.out.println("given day" + dayIn);

		String newmonth = "";

		// if it is todays date, differemt class,

		TestUtil.loopMonthandDay(currentMonth, dayIn, monthIn, nextMonth, totalDays);

		String checkOutDate = "10-October-2018";

		String dateArrOut[] = TestUtil.splitDate(checkOutDate);
		String dayOut = dateArrOut[0];
		String monthOut = dateArrOut[1];
		String yearOut = dateArrOut[2];

		calendarIconOut.click();

		TestUtil.loopMonthandDay(currentMonth, dayOut, monthOut, nextMonth, totalDays);

		Select select = new Select(travellerSelection);
		select.selectByVisibleText("1 room, 2 adults");

		searchButton.click();

	}

}
