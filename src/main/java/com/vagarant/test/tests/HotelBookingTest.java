package com.vagarant.test.tests;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.vagarant.test.base.TestBase;
import com.vagarant.test.pages.HotelBookingPage;

public class HotelBookingTest extends TestBase {

	HotelBookingPage hotelBookingPage;

	public HotelBookingTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeSuite
	public void setUp() throws IOException {
		initialization();
		hotelBookingPage = new HotelBookingPage();

	}

	@Test
	public void SearchingHotels() throws InterruptedException {

		hotelBookingPage.shouldBeAbleToSearchForHotels();

	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

}
