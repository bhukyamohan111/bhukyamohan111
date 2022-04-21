package methods;

import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CommonMethods {

	public static WebDriver driver;
	public static String url;

	// To Launch browser
	public static void launchBrowser(String browser) {
		/*
		 * try { String workingDir = System.getProperty("user.dir");
		 * System.setProperty("webdriver.chrome.driver",workingDir+
		 * "\\resources\\chromedriver.exe"); driver = new ChromeDriver(); }
		 * catch(WebDriverException e) { System.out.println(e.getMessage()); }
		 */

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().version("100.0.4896.60").setup();
			driver = new ChromeDriver();
		}
		else
		{
			if (browser.equals("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
		}
		driver.manage().window().maximize();
	}

	// closing browser
	public static void closeBrowser() {
		if (driver != null) {
			System.out.println("Closing the browser");
			driver.quit();
		}
	}

	@SuppressWarnings("deprecation")
	public static void launchPage() throws InterruptedException {
		url = "http://automationpractice.com/index.php"; // dev

		// url = "https://opensource-demo.orangehrmlive.com/"; //prod

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@SuppressWarnings("deprecation")
	public static void launchDemoPage() throws InterruptedException {
		url = "https://www.orangehrm.com/hris-hr-software-demo/"; // dev

		// url = "https://opensource-demo.orangehrmlive.com/"; //prod

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
