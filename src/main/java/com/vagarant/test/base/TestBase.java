package com.vagarant.test.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase() throws IOException{
		
		prop=new Properties();
		
		try {
			FileInputStream fis= new FileInputStream("D:\\Selenium\\testvagarant\\codingRound\\src\\main\\java\\com\\vagarant\\test\\config\\config.properties");
			
			prop.load(fis);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
		
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\varanar.UTCCGL\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
						
		}
		
		else if(browserName.equals("firefox")){
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\varanar.UTCCGL\\Downloads\\geckodriver-v0.21.0-win64\\geckodriver");
			driver=new ChromeDriver();
						
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	
	
}
