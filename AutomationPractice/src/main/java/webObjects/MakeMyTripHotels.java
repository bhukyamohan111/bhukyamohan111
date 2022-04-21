package webObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MakeMyTripHotels {
	
	public static WebElement element = null;
	public static List<WebElement> element1 = null;
	
	public static List<WebElement> items(WebDriver driver)
	{
		element1 = driver.findElements(By.xpath("//ul[@id='homefeatured']//a[@class='product-name']"));
		return element1;
	}
	
	public static WebElement city(WebDriver driver)
	{
		element = driver.findElement(By.cssSelector("#city"));
		return element;
	}
	
	public static WebElement loginClick(WebDriver driver)
	{
		return driver.findElement(By.xpath("//div[contains(@class,'loginModal')]"));
		
	}
	
	
	public static WebElement cityInput(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//input[@type='text' and @aria-autocomplete='list']"));
		return element;
	}
	
	
	public static WebElement citySelect(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//ul[@role='listbox']/li//p[contains(@class,'locusLabel')]"));
		return element;
	}

}
