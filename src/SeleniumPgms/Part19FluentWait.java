package SeleniumPgms;
import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class Part19FluentWait 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		WebDriver driver =  new ChromeDriver();
//Declaration		
		
		
		Wait <WebDriver> wait = new FluentWait <WebDriver> (driver).withTimeout(Duration.ofSeconds(30))
											 						.pollingEvery(Duration.ofSeconds(5))
											 						.ignoring(NoSuchElementException.class);	
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Selenium"+Keys.RETURN);
//Usage
		
		WebElement element = wait.until(new Function<WebDriver ,WebElement>() 
						{
							public WebElement apply(WebDriver driver)
							{
								return driver.findElement(By.xpath("//h3[text()='Selenium']"));
							}
						}
									);
		
		element.click();
		
		
		
		Thread.sleep(3000);
		driver.quit();
	}
}
