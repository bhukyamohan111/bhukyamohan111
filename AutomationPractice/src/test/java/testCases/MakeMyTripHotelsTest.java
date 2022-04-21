package testCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import methods.CommonMethods;
import webObjects.MakeMyTripHotels;

public class MakeMyTripHotelsTest extends CommonMethods{
	
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
	}
}
