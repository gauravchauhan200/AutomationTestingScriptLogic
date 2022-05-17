package SeleniumPgms;
import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Part09DropDownBootstraps 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		ChromeOptions o=new ChromeOptions();
		o.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(o);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.hdfcbank.com/");
		
		
		
		driver.findElement(By.xpath("//div[@class='drp1']//div[@class='dropdown']/a")).click();
		List <WebElement> drpDownProductTypesElts = driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));
		multiDropDown(drpDownProductTypesElts,"Loans");
	
		
		driver.findElement(By.xpath("//div[@class='drp2']//div[@class='dropdown']//a[@class='btn-primary dropdown-toggle btn-block']")).click();
		List <WebElement> drpDownProducts = driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']/li"));
		multiDropDown(drpDownProducts,"Government Sponsored Programs");
		
		
		
		Thread.sleep(4000);
		driver.quit();
	}

	
	public static void multiDropDown(List <WebElement> drpDownElts,String value)
	{
		for(WebElement li:drpDownElts)
		{
			if(li.getText().equals(value))
			{
			System.out.println("Element is Selected : "+li.getText());
			li.click();
			break;
			}
		}
	}
	
	
}
