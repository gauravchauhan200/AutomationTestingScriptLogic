package SeleniumPgms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Part13AutoCompleteGooglePlaces 
{
	public static void main(String[] args) throws InterruptedException
	{
	
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		ChromeOptions o =  new ChromeOptions();
		o.addArguments("--disable--notifications");
		WebDriver driver =  new ChromeDriver(o);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.twoplugs.com");
	
		
		driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
		WebElement searchbox=driver.findElement(By.xpath("//input[@id='autocomplete']"));
		searchbox.clear();
		searchbox.sendKeys("Toronto");
		
		String text;
		do 
		{
			searchbox.sendKeys(Keys.ARROW_DOWN);
			text=searchbox.getAttribute("value");
			Thread.sleep(2000);
			
			if(text.equals("Toronto Premium Outlets, Steeles Avenue West, Toronto, ON, Canada"))
			{
				searchbox.sendKeys(Keys.ENTER);
				break;
			}
		}
		while(!text.isEmpty());
		
	
		Thread.sleep(3000);
		driver.quit();
		
	}
}
