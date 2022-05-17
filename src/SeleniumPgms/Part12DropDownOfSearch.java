package SeleniumPgms;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Part12DropDownOfSearch 
{	
	public static void main(String[] args) throws InterruptedException 
	{
	
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		ChromeOptions o = new ChromeOptions();
		o.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(o);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.bing.com/?toWww=1&redig=DDB74A696E654F3F8FE1A453ECB0A2B3");
		
		
		driver.findElement(By.xpath("//input[@id='sb_form_q']")).click();
		List <WebElement> drpElements =	driver.findElements(By.xpath("//ul[@class='sa_drw']//li[@class='sa_sg']//span"));
		
		for(WebElement ele:drpElements)
			{
				if(ele.getText().equalsIgnoreCase("up election result 2022"))
				{
					System.out.println("Searching :" +"up election result 2022");
					ele.click();
					break;
				}
			}	
		
		
		Thread.sleep(4000);
		driver.quit();
		

	}
}
