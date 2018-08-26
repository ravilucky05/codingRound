package com.vagarant.test.pages;
import com.sun.javafx.PlatformUtil;
import com.vagarant.test.base.TestBase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInPage extends TestBase {

	
    public SignInPage() throws IOException{
    	
    	super();
    	
    }

   
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

        //setDriverPath();
    	/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\varanar.UTCCGL\\Downloads\\chromedriver.exe");
    	driver = new ChromeDriver();*/
    	

        driver.get("https://www.cleartrip.com/");
        waitFor(2000);

        driver.findElement(By.linkText("Your trips")).click();
        driver.findElement(By.id("SignIn")).click();
        waitFor(2000);
        driver.switchTo().frame("modal_window");
        //driver.switchTo().frame(driver.findElement(By.id("modal_window")));
        waitFor(2000);
        driver.findElement(By.id("signInButton")).click();//signInButton

        String errors1 = driver.findElement(By.id("errors1")).getText();
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
        driver.quit();
    }

    private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    /*private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }*/


}
