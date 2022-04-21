package webObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	public static WebElement element = null;
	public static List<WebElement> element1 = null;
	
	public static List<WebElement> items(WebDriver driver)
	{
		element1 = driver.findElements(By.xpath("//ul[@id='homefeatured']//a[@class='product-name']"));
		return element1;
	}
	
	public static WebElement addToCart(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//ul[@id='homefeatured']/li[contains(@style,'-55')]//a[@title='Add to cart']"));
		return element;
	}
	
	public static WebElement login(WebDriver driver)
	{
		return driver.findElement(By.xpath("//input[@id='btnLogin']"));
		
	}

}
