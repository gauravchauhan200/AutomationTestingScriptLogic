package SeleniumPgms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

public class Part23MouseOperations 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.browserstack.com/guide/action-class-in-selenium");
		
		Actions act = new Actions(driver);
		String element =driver.findElement(By.xpath("//*[@id='singlePageArticle']/div[1]/div/div/div[2]/div[1]/div/ul/li[1]/a")).getText();
		
		WebElement ele=driver.findElement(By.xpath("//*[@id='singlePageArticle']/div[1]/div/div/div[2]/div[1]/div/ul/li[1]/a"));
		act.click(ele).perform();
		System.out.println(element);
		
		
		
		
		Thread.sleep(10000);
		driver.quit();
	}
}
