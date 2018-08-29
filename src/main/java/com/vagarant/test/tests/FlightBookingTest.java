package com.vagarant.test.tests;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.vagarant.test.base.TestBase;
import com.vagarant.test.pages.FlightBookingPage;

public class FlightBookingTest extends TestBase {

	FlightBookingPage flightBookingPage;

	public FlightBookingTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeSuite
	public void setUp() throws IOException {
		initialization();
		flightBookingPage = new FlightBookingPage();

	}

	@Test
	public void testThatResultsAppearForAOneWayJourney() {

		flightBookingPage.testThatResultsAppearForAOneWayJourney();

	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

}
