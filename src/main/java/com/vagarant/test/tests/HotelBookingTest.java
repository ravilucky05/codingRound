package com.vagarant.test.tests;
import com.sun.javafx.PlatformUtil;
import com.vagarant.test.base.TestBase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HotelBookingTest extends TestBase {

    

   /* @FindBy(linkText = "Hotels")
    private WebElement hotelLink;*/
    
	@FindBy(xpath = ".//a[contains(@title,'Find hotels in destinations around the world')]")
    private By hotelLink;

   // @FindBy(id = "Tags")
    //private WebElement localityTextBox;
    
  // WebElement  localityTextBox= driver.

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;
    
    public HotelBookingTest() throws IOException{
    	PageFactory.initElements(driver, this);
    }

    @Test
    public void shouldBeAbleToSearchForHotels() throws InterruptedException {
    	
       /* //setDriverPath();
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\varanar.UTCCGL\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();*/
        PageFactory.initElements(driver, HotelBookingTest.class);

        /*driver.get("https://www.cleartrip.com/");*/
       WebDriverWait wait1 = new WebDriverWait(driver, 500);
        wait1.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(".//a[contains(@title,'Find hotels in destinations around the world')]")))).click();
        
        wait1.until(ExpectedConditions.visibilityOfElementLocated((hotelLink))).click();
        //Thread.sleep(10000);
       // hotelLink.click();
       // wait1.until(ExpectedConditions.visibilityOfElementLocated(localityTextBox));

       // localityTextBox.sendKeys("Indiranagar, Bangalore");

        new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
        searchButton.click();

        driver.quit();

    }

    private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }

}
