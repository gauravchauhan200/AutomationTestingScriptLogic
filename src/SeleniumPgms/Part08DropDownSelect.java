package SeleniumPgms;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Part08DropDownSelect 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://www.opencart.com/index.php?route=account/register");
		
		
		WebElement drpCountryEle=driver.findElement(By.xpath("//select[@name='country_id']"));
		Select drpCountry=new Select(drpCountryEle);
		
		drpCountry.selectByValue("99");
	//	drpCountry.selectByVisibleText("India");
	//	drpCountry.selectByIndex(98);
	
	Thread.sleep(3000);
	driver.quit();
	}
}