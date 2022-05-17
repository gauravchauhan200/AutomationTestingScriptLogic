package SeleniumPgms;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Part08DropDownsForLoop 
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://www.opencart.com/index.php?route=account/register");
		
		WebElement drpCountryElement = driver.findElement(By.id("input-country"));
		selectOptionFromDrop(drpCountryElement,"India");
		
		Thread.sleep(8000);
		driver.quit();
	}	
		
	public static void selectOptionFromDrop(WebElement drpEle,String value)
		{
			Select drp=new Select(drpEle);
			List <WebElement> allOptions=drp.getOptions();
			
			for(WebElement option : allOptions)
			{
				if(option.getText().equals(value))
				{	
					System.out.println(option.getText());
					option.click();
					break;
				}
			}
		}
}
