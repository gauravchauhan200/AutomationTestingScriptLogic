package SeleniumPgms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Part27OpenLinkInNewtab 
{
	public static void main(String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.google.com");
		Thread.sleep(3000);
		driver.get("https://demo.nopcommerce.com/");
		
		String tab = Keys.chord(Keys.CONTROL,Keys.RETURN);
		driver.findElement(By.xpath("//a[text()='Register']")).sendKeys(tab);
		
		
		
		Thread.sleep(6000);
		driver.quit();
	}
}
