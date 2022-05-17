package SeleniumPgms;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Part16HandleLink 
{
	public static void main(String args[]) throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "//drivers//chromedriver.exe");
		
		ChromeOptions o = new ChromeOptions();
		o.addArguments("--disable-notifications");
		
		WebDriver driver = new ChromeDriver(o);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");
		
	
		
		List <WebElement> allLinks =driver.findElements(By.xpath("//a"));
	
		for(int i=0;i<=allLinks.size()-1;i++)
		{
			System.out.println(allLinks.get(i).getText());
			System.out.println(allLinks.get(i).getAttribute("href"));
		}
		
		
		
		Thread.sleep(4000);
		driver.quit();
	}
}
