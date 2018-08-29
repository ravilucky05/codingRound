package com.vagarant.test.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestUtil extends com.vagarant.test.base.TestBase {

	public TestUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void switchToFrame(String wname) {
		driver.switchTo().frame(wname);
	}

	public static void switchToTab() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

		/*
		 * for(String tab:tabs) { System.out.println(tab); }
		 */
		driver.switchTo().window(tabs.get(1));
		System.out.println("switched new tab");
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");

		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));

	}

	public static void selectDateJS(WebElement element, WebDriver driver, String dateVal) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value','" + dateVal + "')", element);

	}

	public static void selectDate(String dayM, List<WebElement> totalMonthsM) {

		List<WebElement> tdtr = totalMonthsM;

		for (int j = 0; j < tdtr.size(); j++) {

			System.out.println("inside for loop");
			System.out.println(tdtr.get(j).getText() + " loop number" + j);

			if (tdtr.get(j).getText().equals(dayM)) {

				System.out.println("day found");
				tdtr.get(j).click();
				break;

			}

		}
	}

	public static boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static String[] splitDate(String cDate) {
		String dateArr[] = cDate.split("-");

		return dateArr;

	}

	public static void loopMonthandDay(List<WebElement> currentMonthM, String dayM, String monthM,
			WebElement nextMonthM, List<WebElement> totalMonthsM) {
		for (int m = 1; m < 50; m++) {
			List<WebElement> curDates = currentMonthM;

			if (curDates.get(0).getText().equals(monthM)) {

				System.out.println("selected month");
				TestUtil.selectDate(dayM, totalMonthsM);
				break;

			}
			nextMonthM.click();

		}

	}

	public static void waitFor(int durationInMilliSeconds) {
		try {
			Thread.sleep(durationInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}
	}

	public static String getCurrentDay() {

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");
		String strDate = formatter.format(date);
		return strDate;

	}

}
