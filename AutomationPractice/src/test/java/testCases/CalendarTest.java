package testCases;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import methods.CommonMethods;

public class CalendarTest extends CommonMethods{
	
	static int yearInput=2021;
	
	@BeforeTest
	public static void launchChrome() throws InterruptedException
	{
		launchBrowser("chrome");
	}
	
	
	@Test(priority=0)
	public static void launchURL() throws InterruptedException
	{
		driver.get("https://www.globalsqa.com/demo-site/datepicker/");
	}
	
	@Test(priority=1)
	public static void goToFrame() throws InterruptedException
	{
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@class,'lazyloaded')]")));
	}
	
	@Test(priority=2)
	public static void simpleDate() throws InterruptedException
	{
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("datepicker"))));
		driver.findElement(By.id("datepicker")).click();
	}
	
	@Test(priority=3)
	public static void selectYear() throws InterruptedException
	{
		int year =Integer.valueOf(driver.findElement(By.className("ui-datepicker-year")).getText());
		if(year!=yearInput)
		{
			if(year<yearInput)
			{
				while(Integer.valueOf(driver.findElement(By.className("ui-datepicker-year")).getText())<yearInput)
				{
					driver.findElement(By.xpath("//span[contains(@class,'ui-icon-circle-triangle-e')]")).click();
				}
			}
			else {
				
				while(Integer.valueOf(driver.findElement(By.className("ui-datepicker-year")).getText())>yearInput)
				{
					driver.findElement(By.xpath("//span[contains(@class,'ui-icon-circle-triangle-w')]")).click();
				}
			}
		}
	}
	
	@Test(priority=4)
	public static void selectDate() throws InterruptedException
	{
		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='20']")).click();
	}
	
	
	
	@AfterTest
	public static void closeChrome() throws InterruptedException
	{
		closeBrowser();
	}
}
