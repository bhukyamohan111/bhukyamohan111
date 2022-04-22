package testCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import methods.CommonMethods;
import webObjects.MakeMyTripHotels;

public class MakeMyTripHotelsTest extends CommonMethods{
	
	static String cityName = "Hyderabad";
	
	@BeforeTest
	public static void launchBrowser() throws InterruptedException
	{
		launchBrowser("chrome");
	}
	
	@Test(priority=0)
	public static void launchURL() throws InterruptedException
	{
		driver.get("https://www.makemytrip.com/hotels/");
	}

	@Test(priority=1)
	public static void loginClick() throws InterruptedException
	{
		MakeMyTripHotels.loginClick(driver).click();
	}
	
	
	@Test(priority=2)
	public static void cityCLick() throws InterruptedException
	{
		MakeMyTripHotels.city(driver).click();
	}

	@Test(priority=3)
	public static void selectCity() throws InterruptedException
	{
		selectCity(cityName);		
	}
	
	@Test(priority = 4)
	public static void clicklongcardclose() throws InterruptedException {
		MakeMyTripHotels.clicklangcardClose(driver).click();
	}
	
	@Test(priority = 5)
	public static void selectTodayDate() throws InterruptedException {
		
		MakeMyTripHotels.todayDate(driver).click();
	}
	/*
	@Test(priority = 6)
	public static void selectEndDate() throws InterruptedException {
		
		MakeMyTripHotels.selectDate(driver, 25).click();
	}*/
	
	@Test(priority = 6)
	public static void selectEndDate() throws InterruptedException {
		
		MakeMyTripHotels.selectDate(driver, "25", "Apr").click();
	}

	
	/*
	@Test(priority=3)
	public static void cityInput() throws InterruptedException
	{
		Thread.sleep(3000);
		MakeMyTripHotels.cityInput(driver).sendKeys("dubai");
	}
	
	@Test(priority=4)
	public static void citySelect() throws InterruptedException
	{
		Thread.sleep(3000);
		MakeMyTripHotels.citySelect(driver).click();
	}*/
	
	
	public static void selectCity(String city) throws InterruptedException
	{
		Thread.sleep(3000);
		for(int i =0; i< MakeMyTripHotels.cityList(driver).size(); i++)
		{
			if(MakeMyTripHotels.cityList(driver).get(i).getText().equals(city))
			{
				MakeMyTripHotels.cityList(driver).get(i).click();
				break;
			}
		}
		
	}
	
	@AfterTest
	public static void closeChrome() throws InterruptedException
	{
		closeBrowser();
	}
}
