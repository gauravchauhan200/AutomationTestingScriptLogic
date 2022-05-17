package SeleniumPgms;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Part18iFrame 
{
	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");	
		ChromeOptions o = new ChromeOptions();
		o.addArguments("--disable-notifications");
	
		WebDriver driver = new ChromeDriver(o);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
	
		
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='packageListFrame']")));
		driver.findElement(By.xpath("//a[text()='org.openqa.selenium.chromium']")).click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='packageFrame']")));
		driver.findElement(By.xpath("//a//span[text()='HasNetworkConditions']")).click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Package, class and interface descriptions']")));
		driver.findElement(By.xpath("//a[text()='Instance Methods']")).click();
		System.out.println("Title of this Frame is : "+driver.getTitle());
		
		
		
		Thread.sleep(3000);
		driver.quit();
	}

}