package testCases;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import methods.CommonMethods;
import webObjects.HomePage;

public class HomePageTest extends CommonMethods{
	
	static ArrayList<String> itemsList= new ArrayList<String>();
	static String itemName="Printed Summer Dress";
	
	@BeforeTest
	public static void launchChrome() throws InterruptedException
	{
		launchBrowser("chrome");
	}
	
	
	@Test(priority=0)
	public static void launchURL() throws InterruptedException
	{
		launchPage();
	}
	
	@Test(priority=1)
	public static void ItemsCount() throws InterruptedException
	{
		getItemsCount();
		System.out.println("in items count method");
	}
	
	@Test(priority=2)
	public static void getItemsList() throws InterruptedException
	{
		int size = getItemsCount();
		System.out.println("items count on Home Page : "+size);
		for(int i =0; i<size; i++)
		{
			itemsList.add(HomePage.items(driver).get(i).getText());
		}
		
		//System.out.println("items on Home Page : "+itemsList);
		
		for(int i =0; i<size; i++)
		{
			System.out.println("text of item "+(i+1)+" is : "+itemsList.get(i));
		}
		
	}
	
	@Test(priority=3)
	public static void selectItem() throws InterruptedException
	{
		addItemToCart(itemName);
	}
	
	@Test(priority=4)
	public static void validateTitle() throws InterruptedException
	{
		String title = driver.getTitle();
		System.out.println("Title after click : "+title);
		assertEquals(title, "My Store");
	}
	
	@AfterTest
	public static void closeChrome() throws InterruptedException
	{
		closeBrowser();
	}
	
	public static int getItemsCount() throws InterruptedException
	{
		int count = HomePage.items(driver).size();
		return count;
	}
	
	public static void addItemToCart(String dressName) throws InterruptedException
	{
		for(int i =0; i<getItemsCount(); i++)
		{
			if(itemsList.get(i).equals(dressName))
			{
				Actions a = new Actions(driver);
				a.moveToElement(HomePage.items(driver).get(i)).build().perform();
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", HomePage.addToCart(driver));
				break;
			}
		}
	}
}
