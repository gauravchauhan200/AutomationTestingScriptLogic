package SeleniumPgms;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Part12AutoSuggestDropDown_GoogleSearch
{
	public static void main(String[] args) throws InterruptedException 
	{
		
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "//drivers//chromedriver.exe");
			ChromeOptions o = new ChromeOptions();
			o.addArguments("--disable-notifications");
			WebDriver driver =  new ChromeDriver(o);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get("https://www.google.com/");
			
			
			
			driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("selenium");
			Thread.sleep(3000);
			
			List <WebElement> list = driver.findElements(By.xpath("//li[@class='sbct']//div[@class='wM6W7d']/span"));
			System.out.println(list.size());
			
			
			for(WebElement listItem : list)
			{	
				if(listItem.getText().contains("rich foods"))
				{
					listItem.click();
					break;
				}
			}
			
			
			Thread.sleep(3000);
			driver.quit();
	}
}
